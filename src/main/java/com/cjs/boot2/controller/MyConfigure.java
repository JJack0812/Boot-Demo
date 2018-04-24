package com.cjs.boot2.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MyConfigure extends WebMvcConfigurerAdapter {

    /**
     * 这个函数可以配置controller，
     * 因为有些简单的跳转不需要再编写controller了，使用这个config就可以自动配置，注意注解
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/addview").setViewName("/addview");
        registry.addViewController("/").setViewName("index");

    }
}
