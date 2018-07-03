package com.example.greendaodemo.sql;


import com.example.greendaodemo.InitApplication;
import com.example.greendaodemo.sql.dao.DaoMaster;
import com.example.greendaodemo.sql.dao.DaoSession;

/**
 * Created by yuanpk on 2017/12/19.
 * <p>
 * 也是个不错的封装，双重锁
 */

public class GreenDaoManager2 {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager2 mInstance; //单例

    private GreenDaoManager2() {
        DaoMaster.DevOpenHelper devOpenHelper = new
                DaoMaster.DevOpenHelper(InitApplication.getContext(), "user1-db", null);//此处为自己需要处理的表
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager2 getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager2.class) {//保证异步处理安全操作

                if (mInstance == null) {
                    mInstance = new GreenDaoManager2();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

}
