package com.qing.dao;

import com.qing.entity.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookMapper {
    List<Book> findAllBooks();

    Book findBookById(int id);

    void addBook(Book book);

    void addBook(Map map);

    void updateBook(Book book);

    void delBook(int id);

    List<Book> findBookByName(String name);

    List<Book> searchBook(HashMap map);

    void delBooks(int[] ids);
}
