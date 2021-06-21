package com.webapp.service;

import com.webapp.dao.BooksMapper;
import com.webapp.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService {

    BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBookByID(int id) {
        return booksMapper.deleteBookByID(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books selectBookByID(int id) {
        return booksMapper.selectBookByID(id);
    }

    @Override
    public List<Books> selectBook() {
        return booksMapper.selectBook();
    }
}
