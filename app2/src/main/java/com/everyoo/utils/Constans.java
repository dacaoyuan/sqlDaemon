package com.everyoo.utils;

/**
 * Created by abc on 2017/3/10.
 */

public class Constans {
    public static final String TABLE_NAME2 = "Category";
    public static final String CREATE_CATEGORY = "create table " + TABLE_NAME2
            + "(id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code text)";


    public static final String TABLE_NAME = "Book";

    public static final String CREATE_BOOK = "create table " + TABLE_NAME
            + "(id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";


}
