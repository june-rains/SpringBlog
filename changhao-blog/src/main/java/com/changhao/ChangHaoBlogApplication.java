package com.changhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.changhao.mapper")
public class ChangHaoBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChangHaoBlogApplication.class, args);
    }
}
