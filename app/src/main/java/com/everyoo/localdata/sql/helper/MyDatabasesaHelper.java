package com.everyoo.localdata.sql.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abc on 2017/3/8.
 */

public class MyDatabasesaHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "BookStore.db";
    public static final String TABLE_NAME = "Book";
    public static final String TABLE_NAME2 = "Category";
    public static final int DB_VERSION = 1;
    private Context mContext;

    public static final String CREATE_BOOK = "create table " + TABLE_NAME
            + "(id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";


    public static final String CREATE_CATEGORY = "create table " + TABLE_NAME2
            + "(id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code text)";


    public MyDatabasesaHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        //db.execSQL(CREATE_CATEGORY);
        System.out.println("MyDatabasesaHelper.onCreate create succeeded");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_CATEGORY);//在数据库 1 版本的 下一版做的升级操作（添加了一张表）
            case 2:
                db.execSQL("alter table " + TABLE_NAME2 + " add column category_id integer");//在数据库 2 版本的 下一版做的升级操作（在添加的新表中，新增了字段）
            default:
        }*/


        //显然这样处理比较暴力
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL(CREATE_BOOK);*/
    }
















      /*public MyDatabasesaHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }*/
}
