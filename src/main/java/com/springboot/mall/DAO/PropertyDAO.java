package com.springboot.mall.DAO;
  
import java.util.List;

import com.springboot.mall.pojo.Category;
import com.springboot.mall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.springboot.mall.pojo.Category;
import com.springboot.mall.pojo.Property;

public interface PropertyDAO extends JpaRepository<Property,Integer>{
    Page<Property> findByCategory(Category category, Pageable pageable);
    List<Property> findByCategory(Category category);
}