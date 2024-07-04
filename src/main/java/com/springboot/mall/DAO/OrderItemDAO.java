package com.springboot.mall.DAO;

import com.springboot.mall.pojo.Order;
import com.springboot.mall.pojo.OrderItem;
import com.springboot.mall.pojo.Product;
import com.springboot.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

 
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}