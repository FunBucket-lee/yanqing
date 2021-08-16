package com.qing.dao;

import com.qing.entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookDao {
    private static Map<String, Book> books = new HashMap<String, Book>();

    static {
        books.put("1", new Book("1", "西游记", 20, "吴承恩"));
        books.put("2", new Book("2", "水浒传", 20, "施耐奄"));
        books.put("3", new Book("3", "三国演义", 30, "罗贯中"));
        books.put("4", new Book("4", "红楼梦", 10, "曹雪芹"));
    }

    //得到所有书
    public static Map<String, Book> findAllBooks() {
        return books;
    }

    public static List<Book> bookList() {
        List<Book> booklist = new ArrayList<Book>();
        booklist.add(new Book("1", "西游记", 20, "吴承恩"));
        booklist.add(new Book("2", "水浒传", 20, "施耐奄"));
        booklist.add(new Book("3", "三国演义", 30, "罗贯中"));
        booklist.add(new Book("4", "红楼梦", 10, "曹雪芹"));
        return booklist;
    }

    /**
     * 根据id查找指定的书
     *
     * @param id
     * @return
     */
    public static Book findBookById(String id) {
        return books.get(id);
    }
}
