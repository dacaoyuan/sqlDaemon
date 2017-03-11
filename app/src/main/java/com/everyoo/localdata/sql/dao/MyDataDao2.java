package com.everyoo.localdata.sql.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.everyoo.localdata.sql.helper.MyDatabasesaHelper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abc on 2017/3/8.
 */

public class MyDataDao2 {

    private static MyDatabasesaHelper helper;
    private static MyDataDao2 instance = null;
    private SQLiteDatabase db;
    private AtomicInteger mOpenCounter = new AtomicInteger();//数据可打开关闭标记器，可解决重复打开关闭数据库的问题

    public MyDataDao2() {

    }


    /*public static MyDataDao getInstance(Context context){
        if(instance==null){
            synchronized (DBUserDao.class) {
                if(instance==null){
                    instance = new DBUserDao(context);
                }
            }
        }
        return INSTANCE;
    }*/

    /*public synchronized static MyDataDao getInstance(Context context) {
        if (instance == null) {
            instance = new MyDataDao();
            helper = new MyDatabasesaHelper(context);

        }
        return instance;
    }*/

    /**
     * 双重锁
     */
    protected MyDataDao2(Context context) {
        if (helper == null) {
            synchronized (MyDataDao2.class) {
                if (helper == null) {
                    helper = new MyDatabasesaHelper(context);
                }
            }
        }
    }

    /**
     * 得到可写入数据数据库
     */
    public synchronized SQLiteDatabase getWritableDatabase() {
        if (mOpenCounter.incrementAndGet() == 1) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    /**
     * 得到可读取数据的数据库
     */
    public synchronized SQLiteDatabase getReadableDatabase() {
        if (mOpenCounter.incrementAndGet() == 1) {
            db = helper.getReadableDatabase();
        }
        return db;
    }

    /**
     * 关闭数据库连接
     */
    public synchronized void closeDatabase() {
        if (mOpenCounter.decrementAndGet() == 0) {
            db.close();
        }
    }















    /*有人可能注意到了ATomicInteger，那么这个是做什么用的呢。
    作用是:每当你使用DBDao的getReadableDatabase()和getWritableDatabase()方法来取得数据库。
    我们会使用一个引用计数来判断是否要创建数据库对象。如果引用计数为1，则需要创建一个数据库，如果不为1，说明我们已经创建过了。
    在closeDatabase()方法中我们同样通过判断引用计数的值，如果引用计数降为0，则说明我们需要close数据库。
    这样做的目的是：因为我们每进行一次数据库操作完毕后是要关闭数据库连接的，这样反复进行数据操作时我们要反复要对数据库进行打开关闭的操作，
    虽然在StackOverflow上推荐的做法是永远不要关闭数据库。Android会尊重你这种做法，但会给你如下的提示。
    Caused by: java.lang.IllegalStateException: SQLiteDatabase created and never closed
    所以我一点也不推荐这种做法。*/


}
