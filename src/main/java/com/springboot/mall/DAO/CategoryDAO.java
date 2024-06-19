package com.springboot.mall.DAO;
  
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.springboot.mall.pojo.Category;
 
public interface CategoryDAO extends JpaRepository<Category,Integer>{
 
}