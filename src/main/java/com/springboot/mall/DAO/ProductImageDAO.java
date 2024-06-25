package com.springboot.mall.DAO;
  
import java.util.List;

import com.springboot.mall.pojo.Product;
import com.springboot.mall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

 
public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
     
}