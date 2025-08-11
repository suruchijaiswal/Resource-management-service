package com.example.reporting.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/***Author:Suruchi*/
public class FeignClientConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;  // Logs all Feign request details
    }
}
