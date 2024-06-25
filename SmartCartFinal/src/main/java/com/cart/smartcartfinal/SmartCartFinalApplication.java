package com.cart.smartcartfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SmartCartFinalApplication {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(SmartCartFinalApplication.class, args);
    }

}
