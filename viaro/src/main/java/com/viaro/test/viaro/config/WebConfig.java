package com.viaro.test.viaro.config;

import jakarta.annotation.Nonnull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@Nonnull CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS");
                //registry.addMapping("/api/v1/**").allowedOrigins("http://localhost:4200").allowedMethods()
            }
        };
    }
}
