package com.springboot.mall.DAO;

import com.springboot.mall.pojo.Product;
import com.springboot.mall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface ReviewDAO extends JpaRepository<Review,Integer>{

    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);

}