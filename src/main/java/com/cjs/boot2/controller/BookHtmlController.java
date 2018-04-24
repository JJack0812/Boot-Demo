package com.cjs.boot2.controller;

import com.cjs.boot2.bean.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BookHtmlController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/bookhtml")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("/BooksTemplate");
        modelAndView.addObject("list",bookRepo.findAll());
        return modelAndView;
    }
}
