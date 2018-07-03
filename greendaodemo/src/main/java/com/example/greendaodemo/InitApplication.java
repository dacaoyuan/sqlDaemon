package com.example.greendaodemo;

import android.app.Application;
import android.content.Context;

import com.example.greendaodemo.sql.GreenDaoManager;


/**
 * Created by yuanpk on 2017/12/19.
 */

public class InitApplication extends Application {


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //GreenDao的初始化
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }



}
