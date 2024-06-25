package com.springboot.mall.DAO;
  
import java.util.List;

import com.springboot.mall.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

 
public interface OrderDAO extends JpaRepository<Order,Integer>{
}