package com.webapp.service;

import com.webapp.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    //    增加一个Book
    int addBook(Books books);

    //    删除一个Book(根据ID)
    int deleteBookByID(@Param("bookID") int id);

    //    修改一个Book
    int updateBook(Books books);

    //    查询一个Book(根据ID)
    Books selectBookByID(@Param("bookID") int id);

    //    查询全部Book
    List<Books> selectBook();

    //    查询一个Book(根据Name)
    Books selectBookByName(@Param("bookName") String bookName);
}
