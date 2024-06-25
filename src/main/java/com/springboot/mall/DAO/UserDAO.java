package com.springboot.mall.DAO;
  
import com.springboot.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

 
public interface UserDAO extends JpaRepository<User,Integer>{
 
}