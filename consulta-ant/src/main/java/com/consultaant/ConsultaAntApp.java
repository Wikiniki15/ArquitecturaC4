package com.consultaant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ConsultaAntApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsultaAntApp.class, args);
    }
}
