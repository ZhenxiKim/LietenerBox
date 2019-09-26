package com.example.lietenerbox;

//import com.apple.eawt.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class LietenerboxApplication {

    /*
    swagger ui 경로
    http://localhost:8080/swagger-ui.html
    */

    public static void main(String[] args) {

        SpringApplication.run(LietenerboxApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("LietnerBox")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.ant("/api/**"))//api로 선언된 부분만 api 문서
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("LietnerBox API")
                .description("LietnerBox API")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

}
