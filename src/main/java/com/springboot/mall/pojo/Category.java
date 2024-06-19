package com.springboot.mall.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity//表示这是一个实体类
@Table(name = "category")//表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
/*因为是做前后端分离，而前后端数据交互用的是 json 格式。
 那么 Category 对象就会被转换为 json 数据。
 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate,
 在 jpa 工作过程中，就会创造代理类来继承 Category ，
 并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，
 所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。*/
public class Category {
    @Id//标注用于声明一个实体类的属性映射为数据库的主键列
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*用于标注主键的生成策略，通过strategy 属性指定
    在javax.persistence.GenerationType中定义了以下几种可供选择的策略：
        –IDENTITY：采用数据库ID自增长的方式来自增主键字段，Oracle 不支持这种方式；
        –AUTO： JPA自动选择合适的策略，是默认选项；
        –SEQUENCE：通过序列产生主键，通过@SequenceGenerator 注解指定序列名，MySql不支持这种方式
        –TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。*/
    @Column(name = "id")//用来标识实体类中属性与数据表中字段的对应关系;最好标注在定义的属性前
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
