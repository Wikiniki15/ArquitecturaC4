package com.consultaciudadano;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableCaching
public class ConsultaCiudadanoApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsultaCiudadanoApp.class, args);
    }
}
