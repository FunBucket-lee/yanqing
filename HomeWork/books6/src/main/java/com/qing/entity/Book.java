package com.qing.entity;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private double price;
    private String category;
    private int pnum;
    private String imgurl;
    private String description;
    private String author;
    private int sales;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Book() {
    }

    public Book(int id, String name, double price, String category, int pnum, String imgurl, String description, String author, int sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.pnum = pnum;
        this.imgurl = imgurl;
        this.description = description;
        this.author = author;
        this.sales = sales;
    }

    public Book(String name, double price, String category, int pnum, String imgurl, String description, String author, int sales) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.pnum = pnum;
        this.imgurl = imgurl;
        this.description = description;
        this.author = author;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", pnum=" + pnum +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                '}';
    }
}
