package com.example.spring.bootdemo.controller;

import com.example.spring.bootdemo.dto.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Sample hello(){
        Sample sample =new Sample();
        sample.setId(100);
        sample.setName("taro");

        return sample;
    }
}
