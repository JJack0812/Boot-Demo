package com.cjs.boot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/th")
@Controller
public class ThymeController {
    @RequestMapping("/helloleaf")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("model","this is model valueaaaaaaaaaaa");
        return modelAndView;
    }
}
