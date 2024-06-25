package com.cart.smartcartfinal.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/Hello")
    public String HelloWorld()
    {
        System.out.println("Hello World");
        return "Hello World";
    }
}
