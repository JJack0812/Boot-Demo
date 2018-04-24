package com.cjs.boot2.controller;

import com.cjs.boot2.bean.Book;
import com.cjs.boot2.bean.BookRepo;
import com.cjs.boot2.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/book")
    public List<Book> findAll() {
        return bookRepo.findAll();

    }


    /**
     * 表单验证，传入对象加入valid注解，bean对象加入相应的注解，限定值，和错误信息。
     * @param book 传入对象
     * @param bindingResult 检测结果
     * @return
     */
    @Transactional
    @PostMapping("/book")
    public Result addBook(@Valid Book book , BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            Result result = new Result();
            result.setCode(100);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return  result ;
        }
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success!!");
        result.setData(book);

        bookRepo.save(book);
        return result;
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookRepo.deleteById(id);
    }
}
