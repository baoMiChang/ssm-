package com.liuc.service;

import com.liuc.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> selectAll();
    Book selectById(int id);
    int addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
    boolean deleteBooks(int[] ids);
}
