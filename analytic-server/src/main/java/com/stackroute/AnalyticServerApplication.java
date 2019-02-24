package com.stackroute;

import com.stackroute.service.AnalyticServiceImpl;
import com.stackroute.nlpService.NlpServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalyticServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyticServerApplication.class, args);
    }
}