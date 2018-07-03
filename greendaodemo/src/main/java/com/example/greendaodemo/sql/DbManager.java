package com.example.greendaodemo.sql;

import android.content.Context;
import android.util.Log;


import com.example.greendaodemo.sql.dao.DaoMaster;
import com.example.greendaodemo.sql.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by yuanpk on 2017/12/19.
 * <p>
 * 可以选择加密数据库的封装
 */

public class DbManager {
    private static final String TAG = "DbManager";
    // 是否加密
    public static final boolean ENCRYPTED = true;


    private static DbManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    public static DaoMaster mDaoMaster;
    public static DaoSession mDaoSession;

    private DbManager(Context context, String dbName, String passwprd) {
        // 初始化数据库信息
        DaoMaster.DevOpenHelper mDevOpenHelper = new DaoMaster.DevOpenHelper(context, dbName);

        mDaoMaster = new DaoMaster(getWritableDatabase(context, dbName, passwprd));
        mDaoSession = mDaoMaster.newSession();
       // mDaoSession = mDaoMaster.newDevSession(context, dbName);//这个再进一层，发现，返回的db，是未加密的

        //getDaoMaster(context, dbName, passwprd);
        //getDaoSession(context, dbName, passwprd);
    }

    public static DbManager getInstance(Context context, String dbName, String passwprd) {
        if (null == mDbManager) {
            synchronized (DbManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbManager(context, dbName, passwprd);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
  /*  public static Database getReadableDatabase(Context context, String dbName, String passwprd) {
        if (null == mDevOpenHelper) {
            getInstance(context, dbName, passwprd);
        }
        if (ENCRYPTED) {//加密
            return mDevOpenHelper.getEncryptedReadableDb(passwprd);
        } else {
            return mDevOpenHelper.getReadableDb();
        }
    }*/

    /**
     * 获取可写数据库
     *
     * @param context
     * @param dbName
     * @param passwprd
     * @return
     */
    public static Database getWritableDatabase(Context context, String dbName, String passwprd) {
        if (null == mDevOpenHelper) {
            getInstance(context, dbName, passwprd);
        }
        if (ENCRYPTED) {//加密
            Log.i(TAG, "getWritableDatabase: 加密 passwprd=" + passwprd);
            return mDevOpenHelper.getEncryptedWritableDb(passwprd);
        } else {
            return mDevOpenHelper.getWritableDb();
        }
    }

    /**
     * 获取DaoMaster
     *
     * @param context
     * @param dbName
     * @param passwprd
     * @return
     */
    /*public static DaoMaster getDaoMaster(Context context, String dbName, String passwprd) {
        if (null == mDaoMaster) {
            synchronized (DbManager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context, dbName, passwprd));
                }
            }
        }
        return mDaoMaster;
    }*/

    /**
     * 获取DaoSession
     *
     * @param context
     * @param dbName
     * @param passwprd
     * @return
     */
    /*public static DaoSession getDaoSession(Context context, String dbName, String passwprd) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
               mDaoSession = getDaoMaster(context,dbName,passwprd).newSession();
              // mDaoSession = getDaoMaster(context, dbName, passwprd).newDevSession(context, dbName); //这个再进一层，发现，返回的db，是未加密的
            }
        }

        return mDaoSession;
    }*/
}