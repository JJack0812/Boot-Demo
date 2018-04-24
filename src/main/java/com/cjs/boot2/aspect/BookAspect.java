package com.cjs.boot2.aspect;

import com.cjs.boot2.bean.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class BookAspect {

    private final static Logger logger = LoggerFactory.getLogger(BookAspect.class);
    /**
     * 切面，在执行到注解内定义的方法时之前执行切面方法
     */


    //注解内内容重复，冗余了
//    @Before("execution(public  * com.cjs.boot2.controller.BookController.deleteBook(..))")
//    public void logBefore(){
//        System.out.println("拦截到delete方法,预警！！");
//    }
//    @After("execution(public * com.cjs.boot2.controller.BookController.deleteBook(..))")
//    public void logAfter(){
//        System.out.println("删除完成，gg");
//    }
    @Pointcut("execution(public * com.cjs.boot2.controller.BookController.*(..))")
    public void log(){

    }

//    @Before("log()")
//    public void logBefore(){
//        logger.info("拦截到controller");
//    }
    @After("log()")
    public void logAfter(){
        logger.info("controller方法执行完毕");
    }


    /**
     * 实现切面传参，参数列表要保持一致,只是拦截到了原本方法的参数，拦截http请求看下边的
     */
    @Before(value = "execution(public  * com.cjs.boot2.controller.BookController.addBook(..)) " +
            "&& args(book,bindingResult)"
            )
    public void logBookInfo(Book book, BindingResult bindingResult){
        logger.info("book info>>"+book.toString());


    }

    /**
     *
     */
    @Before("log()")
    public void doBeforeAll(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
