package com.cody;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/13
 */
@EnableElasticsearchRepositories(basePackages = "com.cody.es")
@EnableJpaRepositories(basePackages = {"com.cody.dao", "com.cody.pojo"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
