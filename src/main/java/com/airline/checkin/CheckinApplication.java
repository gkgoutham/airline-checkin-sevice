package com.airline.checkin;

import com.airline.checkin.service.CheckInService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class CheckinApplication {

    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(CheckinApplication.class, args);

        SpringApplication.run(CheckinApplication.class);
    }

    @Bean
    public CheckInService getCheckInService(){
        return  new CheckInService();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
