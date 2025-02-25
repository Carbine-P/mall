package com.springboot.mall.service;


import com.springboot.mall.DAO.CategoryDAO;
import com.springboot.mall.pojo.Category;
import com.springboot.mall.pojo.Product;
import com.springboot.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标记这个类是 Service类
@CacheConfig(cacheNames="categories")
public class CategoryService {
    @Autowired//自动装配;成员属性字段使用 @Autowired，无需字段的 set 方法
    CategoryDAO categoryDAO;

    @Cacheable(key="'categories-page-'+#p0+ '-' + #p1")
    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start,size,sort);//Pageable 接口用于构造分页查询，返回 Page 对象。
        // Page 从0开始分页。start参数表示当前从dao得到的数据中第一个数据的下标
        Page pageFromJPA =categoryDAO.findAll(pageable);//分页查询（含排序功能）。

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    @Cacheable(key="'categories-all'")
    //首先创建一个通过 id 倒排序的Sort 对象，然后通过 categoryDAO进行查询。
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);//排序功能。它按照“Sort”制定的排序返回数据。
    }
    @CacheEvict(allEntries=true)
//  @CachePut(key="'category-one-'+ #p0")
    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    @CacheEvict(allEntries=true)
//  @CachePut(key="'category-one-'+ #p0")
    public void delete(int id) {
        categoryDAO.delete(id);
    }

    @Cacheable(key="'categories-one-'+ #p0")
    public Category get(int id) {
        Category c= categoryDAO.findOne(id);
        return c;
    }

    @CacheEvict(allEntries=true)
//  @CachePut(key="'category-one-'+ #p0")
    public void update(Category bean) {
        categoryDAO.save(bean);
    }

    //在对分类做序列还转换为 json 的时候，会遍历里面的 products, 然后遍历出来的产品上，又会有分类;防止死循环
    public void removeCategoryFromProduct(List<Category> cs) {
        for (Category category : cs) {
            removeCategoryFromProduct(category);
        }
    }

    public void removeCategoryFromProduct(Category category) {
        List<Product> products =category.getProducts();
        if(null!=products) {
            for (Product product : products) {
                product.setCategory(null);
            }
        }

        List<List<Product>> productsByRow =category.getProductsByRow();
        if(null!=productsByRow) {
            for (List<Product> ps : productsByRow) {
                for (Product p: ps) {
                    p.setCategory(null);
                }
            }
        }
    }

}
