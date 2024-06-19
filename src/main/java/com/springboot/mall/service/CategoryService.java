package com.springboot.mall.service;


import com.springboot.mall.DAO.CategoryDAO;
import com.springboot.mall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标记这个类是 Service类
public class CategoryService {
    @Autowired//自动装配;成员属性字段使用 @Autowired，无需字段的 set 方法
    CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

}
