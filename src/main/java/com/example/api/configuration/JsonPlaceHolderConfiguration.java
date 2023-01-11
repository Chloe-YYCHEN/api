package com.example.api.configuration;

import com.example.api.jsonplaceholder.JsonPlaceHolderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceHolderConfiguration {
    Logger logger = LoggerFactory.getLogger(JsonPlaceHolderConfiguration.class);
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JsonPlaceHolderClient jsonPlaceHolderClient){
        return args -> {
            logger.info("https://jsonplaceholder.typicode.com/posts");
            logger.info(String.valueOf(jsonPlaceHolderClient.getPosts().size()));
            logger.info("https://jsonplaceholder.typicode.com/post/1");
            logger.info(String.valueOf(jsonPlaceHolderClient.getPost(1)));
        };
    }
}
