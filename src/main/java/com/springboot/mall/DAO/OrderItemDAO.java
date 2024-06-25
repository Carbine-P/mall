package com.springboot.mall.DAO;
  
import java.util.List;

import com.springboot.mall.pojo.Order;
import com.springboot.mall.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

 
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
}