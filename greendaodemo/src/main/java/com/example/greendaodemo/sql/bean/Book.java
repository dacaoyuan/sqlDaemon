package com.example.greendaodemo.sql.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by yuanpk on 2018/7/2  11:09
 * <p>
 * Description:TODO
 */

@Entity
public class Book {

    //不能用int (autoincrement = true)表示主键会自增，如果false就会使用旧值
    @Id(autoincrement = true)
    private Long id;

    @Unique
    @Property(nameInDb = "book_id")
    private String bookId; //@Unique：该属性值必须在数据库中是唯一值(主键)

    public String bookname;//如果不添加@Property属性，则默认把bookname的大写方式，作为字段的名。

    @Property(nameInDb = "book_address")
    public String bookAddress; //@Property：可以自定义字段名，注意外键不能使用该属性

    @Generated(hash = 1265399634)
    public Book(Long id, String bookId, String bookname, String bookAddress) {
        this.id = id;
        this.bookId = bookId;
        this.bookname = bookname;
        this.bookAddress = bookAddress;
    }

    public Book(String bookId, String bookname, String bookAddress) {
        this.bookId = bookId;
        this.bookname = bookname;
        this.bookAddress = bookAddress;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookname() {
        return this.bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookAddress() {
        return this.bookAddress;
    }

    public void setBookAddress(String bookAddress) {
        this.bookAddress = bookAddress;
    }


}
