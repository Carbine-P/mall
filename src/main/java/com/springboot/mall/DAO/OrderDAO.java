package com.springboot.mall.DAO;

import com.springboot.mall.pojo.Order;
import com.springboot.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

 
public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}