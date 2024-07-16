package com.springboot.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching//@EnableCaching 用于启动缓存
@EnableElasticsearchRepositories(basePackages = "com.springboot.mall.es")
@EnableJpaRepositories(basePackages = {"com.springboot.mall.DAO", "com.springboot.mall.pojo"})
public class Application {
    static {
//        PortUtil.checkPort(6379,"Redis 服务端",true);
        //检查端口6379是否启动。 6379 就是 Redis 服务器使用的端口。如果未启动，那么就会退出 springboot
//        PortUtil.checkPort(9300,"ElasticSearch 服务端",true);
//        PortUtil.checkPort(5601,"Kibana 工具", true);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}