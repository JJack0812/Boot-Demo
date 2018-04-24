package com.cjs.boot2.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BookExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(BookExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void handle(Exception e){
        logger.warn("这是我自己定义的异常处理器"+e.getMessage());
    }
}
