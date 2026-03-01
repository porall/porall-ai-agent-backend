package com.porall.poaiagent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health1")
public class haha {
    @GetMapping
    public String healthCheck(){
        return "ok";
    }
}
