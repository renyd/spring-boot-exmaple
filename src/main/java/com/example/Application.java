package com.example;

import com.example.aop.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by Domg on 2016/11/19.
 */
@SpringBootApplication
@EnableAsync // 启用@Async注解异步方法
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("system start. args:{}", args);
        SpringApplication.run(Application.class, args);
    }


}
