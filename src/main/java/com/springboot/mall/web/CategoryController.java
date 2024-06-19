package com.springboot.mall.web;

import com.springboot.mall.pojo.Category;
import com.springboot.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//表示这是一个控制器;它会将每个方法的返回值都直接转换为 json 数据格式
public class CategoryController {
    @Autowired
    CategoryService categoryService;

/*  对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
    因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。*/
    @GetMapping("/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }
}
