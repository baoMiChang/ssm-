package com.liuc.service.impl;

import com.liuc.mapper.BookMapper;
import com.liuc.pojo.Book;
import com.liuc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }

    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    public boolean updateBook(Book book) {
        try {
            bookMapper.updateBook(book);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteBook(int id) {
        try {
            bookMapper.deleteBook(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteBooks(int[] ids) {
        try {
            bookMapper.deleteBooks(ids);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
