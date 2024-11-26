package com.velas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {
        JdbcTemplateAutoConfiguration.class
})
@EntityScan("com.velas.ecommerce.Entities")
@EnableJpaRepositories(basePackages = "com.velas.ecommerce.Repositories")
public class VelasApplication {
    public static void main(String[] args) {
        SpringApplication.run(VelasApplication.class, args);
    }
}