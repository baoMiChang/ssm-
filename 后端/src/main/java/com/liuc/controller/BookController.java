package com.liuc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuc.pojo.Book;
import com.liuc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/book", produces = "application/json; charset=utf-8")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        int code = books.isEmpty() ? CODE.SELECT_ERR : CODE.SELECT_OK;
        String msg = books.isEmpty() ? "没有检索到数据" : "";
        return new Result(code,books,msg);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id) {
        Book book = bookService.selectById(id);
        int code = book == null ? CODE.SELECT_ERR : CODE.SELECT_OK;
        String msg = book == null ? "没有检索到数据" : "";
        return new Result(code,book,msg);
    }

    @PostMapping
    public Result addBook(@RequestBody Book book) throws JsonProcessingException {
        int i = bookService.addBook(book);
        return new Result(i == 0 ? CODE.ADD_ERR : CODE.ADD_OK,book.getId());
    }

    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        boolean flag = bookService.updateBook(book);
        return new Result(flag == true ? CODE.UPDATE_OK : CODE.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable int id) {
        boolean flag = bookService.deleteBook(id);
        return new Result(flag == true ? CODE.DELETE_OK : CODE.DELETE_ERR, flag);
    }

    @DeleteMapping
    public Result deleteBooks(@RequestBody int[] ids) {
        boolean flag = bookService.deleteBooks(ids);
        return  new Result(flag == true ? CODE.DELETE_OK : CODE.DELETE_ERR, flag);
    }
}

