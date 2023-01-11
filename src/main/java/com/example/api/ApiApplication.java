package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
//在实际生产项目中不要使用H2,仅供测试使用，如你所见每次刷新就会失去所有数据（Spring data JPA）
//SpringBootActuator监控板Grafana