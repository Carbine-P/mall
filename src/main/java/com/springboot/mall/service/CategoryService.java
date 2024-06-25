package com.springboot.mall.service;


import com.springboot.mall.DAO.CategoryDAO;
import com.springboot.mall.pojo.Category;
import com.springboot.mall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标记这个类是 Service类
public class CategoryService {
    @Autowired//自动装配;成员属性字段使用 @Autowired，无需字段的 set 方法
    CategoryDAO categoryDAO;

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start,size,sort);//Pageable 接口用于构造分页查询，返回 Page 对象。
        // Page 从0开始分页。start参数表示当前从dao得到的数据中第一个数据的下标
        Page pageFromJPA =categoryDAO.findAll(pageable);//分页查询（含排序功能）。

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    //首先创建一个通过 id 倒排序的Sort 对象，然后通过 categoryDAO进行查询。
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);//排序功能。它按照“Sort”制定的排序返回数据。
    }
    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    public void delete(int id) {
        categoryDAO.delete(id);
    }

    public Category get(int id) {
        Category c= categoryDAO.findOne(id);
        return c;
    }
    public void update(Category bean) {
        categoryDAO.save(bean);
    }

}
