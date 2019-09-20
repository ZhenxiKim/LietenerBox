package com.example.lietenerbox;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter({Configuration.class})})
@EnableJpaRepositories(
        basePackages = {
                "com.example.lietenerbox.repository",
        }
)
@EntityScan(
        basePackages = {
                "com.example.lietenerbox.model"
        }
)

public class TestConfiguration {
}
