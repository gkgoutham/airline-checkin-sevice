package com.airline.checkin;

import com.airline.checkin.service.CheckInService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class CheckinApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CheckinApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

        for (String beanName : beanNames)
        {
//            System.out.println(beanName);
        }


//        SpringApplication.run(CheckinApplication.class);
    }

    @Bean
    public CheckInService getCheckInService(){
        return  new CheckInService();
    }

}
