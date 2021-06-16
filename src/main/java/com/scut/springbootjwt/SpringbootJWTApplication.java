package com.scut.springbootjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scut.springbootjwt.mapper")
public class SpringbootJWTApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJWTApplication.class, args);
    }
}
