package com.khauminhduy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping(value = "/sample")
    public String showForm() {
        return "sample";
    }

    @GetMapping("/sample2")
    public String showForm2() {
        return "sample2";
    }

    @GetMapping("/sample3")
    public String showForm3() {
        return "sample3";
    }

}
