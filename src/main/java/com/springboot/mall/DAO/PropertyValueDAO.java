package com.springboot.mall.DAO;
  
import java.util.List;

import com.springboot.mall.pojo.Category;
import com.springboot.mall.pojo.Product;
import com.springboot.mall.pojo.Property;
import com.springboot.mall.pojo.PropertyValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    PropertyValue getByPropertyAndProduct(Property property, Product product);

}