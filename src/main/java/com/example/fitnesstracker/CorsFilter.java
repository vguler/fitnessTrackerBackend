package com.example.fitnesstracker.config; // Ajustează pachetul dacă este necesar

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Permite cereri către toate endpoint-urile care încep cu /api/
                .allowedOrigins("http://localhost:3000") // Permite cereri de la originea aplicației React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite toate metodele HTTP
                .allowedHeaders("*"); // Permite toate headerele
    }
}