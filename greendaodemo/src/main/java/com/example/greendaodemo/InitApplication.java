package com.example.greendaodemo;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.sql.GreenDaoManager;
import com.example.greendaodemo.sql.GreenDaoManager2;
import com.example.greendaodemo.sql.dao.DaoMaster;
import com.example.greendaodemo.sql.dao.DaoSession;


/**
 * Created by yuanpk on 2017/12/19.
 */

public class InitApplication extends Application {
    private static DaoSession daoSession;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //GreenDao的初始化
        GreenDaoManager.getInstance();//方法一
        //GreenDaoManager2.getInstance();//方法二
        //setupDatabase();//方法三,如果只是简单的使用，推荐使用这个
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }


}
