package com.qing.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qing.dao.BookMapper;
import com.qing.entity.Book;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    SqlSession session = MyBatisUtil.getSession();
    BookMapper bookMapper = session.getMapper(BookMapper.class);

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = bookMapper.findAllBooks();
        return allBooks;
    }

    @Override
    public Book findBookById(int id) {
        Book book = bookMapper.findBookById(id);
        return book;
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
        session.commit();
    }

    @Override
    public void addBook(Map map) {
        bookMapper.addBook(map);
        session.commit();
    }


    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
        session.commit();
    }

    @Override
    public void delBook(int id) {
        bookMapper.delBook(id);
        session.commit();
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookMapper.findBookByName(name);
    }

    @Override
    public List<Book> searchBook(HashMap map) {
        return bookMapper.searchBook(map);
    }

    @Override
    public void delBooks(int[] ids) {
        bookMapper.delBooks(ids);
        session.commit();
    }

    @Override
    public PageInfo<Book> findAllBooksPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.findAllBooks();
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }

    @Override
    public PageInfo<Book> searchBookPage(int pageNum, int pageSize, HashMap map) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookMapper.searchBook(map);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }
}
