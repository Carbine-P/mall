package com.springboot.mall.service;
 
import java.util.List;

import com.springboot.mall.DAO.PropertyDAO;
import com.springboot.mall.pojo.Category;
import com.springboot.mall.pojo.Property;
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

 
@Service
public class PropertyService {
 
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired CategoryService categoryService;
 
    public void add(Property bean) {
        propertyDAO.save(bean);
    }
 
    public void delete(int id) {
        propertyDAO.delete(id);
    }
 
    public Property get(int id) {
        return propertyDAO.findOne(id);
    }
 
    public void update(Property bean) {
        propertyDAO.save(bean);
    }
 
    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
         
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);    
         
        Page<Property> pageFromJPA =propertyDAO.findByCategory(category,pageable);
         
        return new Page4Navigator<>(pageFromJPA,navigatePages);
         
    }

    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }
 
}