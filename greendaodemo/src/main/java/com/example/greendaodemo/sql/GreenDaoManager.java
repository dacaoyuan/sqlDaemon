package com.example.greendaodemo.sql;

import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.InitApplication;
import com.example.greendaodemo.sql.dao.DaoMaster;
import com.example.greendaodemo.sql.dao.DaoSession;


/**
 * Created by yuanpk on 2017/12/19.
 */

public class GreenDaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        init();
    }

    /**
     * 静态内部类，实例化对象使用
     */
    private static class SingleInstanceHolder {
        private static final GreenDaoManager INSTANCE = new GreenDaoManager();
    }

    /**
     * 对外唯一实例的接口
     *
     * @return
     */
    public static GreenDaoManager getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    /**
     * 初始化数据
     */
    private void init() {
        //创建数据库My369.db"
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(InitApplication.getContext(),
                "My369.db");

        //获取可写数据库
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        //Database db = devOpenHelper.getWritableDb();
        //Database db = devOpenHelper.getEncryptedWritableDb("1212"); //加密


        //获取数据库对象
        mDaoMaster = new DaoMaster(db);

        //获取Dao对象管理者
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getmDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getmDaoSession() {

        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

}
