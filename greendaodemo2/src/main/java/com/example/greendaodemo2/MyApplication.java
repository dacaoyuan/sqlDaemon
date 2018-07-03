package com.example.greendaodemo2;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo2.dao.DaoMaster;
import com.example.greendaodemo2.dao.DaoSession;


/**
 * Created by 29083 on 2018/3/28.
 */

public class MyApplication extends Application {

    public static MyApplication mContext;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;

        //配置数据库
        setupDatabase();

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
