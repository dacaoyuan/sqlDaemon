package com.everyoo.localdata.sql.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by abc on 2017/3/8.
 */

@DatabaseTable(tableName = "Book2")
public class MyBean2 {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    public String name;

    @DatabaseField(columnName = "author")
    public String author;

    @DatabaseField(columnName = "price")
    public String price;

    @DatabaseField(columnName = "pages")
    public int pages;

   /* @DatabaseField(columnName = "book_type")
    public int bookType;

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }*/


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
