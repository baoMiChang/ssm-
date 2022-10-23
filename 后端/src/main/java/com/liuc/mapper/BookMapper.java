package com.liuc.mapper;

import com.liuc.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> selectAll();
    Book selectById(int id);
    int addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    void deleteBooks(int[] ids);
}
