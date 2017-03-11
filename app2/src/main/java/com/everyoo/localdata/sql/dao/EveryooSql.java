package com.everyoo.localdata.sql.dao;

import android.content.Context;

/**
 * Created by abc on 2017/3/8.
 */

public class EveryooSql {
    public static EveryooSql everyooSql = null;
    private static Context mContext;


    private MyDataDao myDataDao;

    public static EveryooSql init(Context context) {
        mContext = context;
        if (everyooSql == null) {
            everyooSql = new EveryooSql();
        }
        return everyooSql;
    }

    public Object getSqlDao(Class clazz) {
        String className = clazz.getSimpleName();
        Object obj = null;

        switch (className) {
            case "MyDataDao":
                myDataDao = (myDataDao == null) ? new MyDataDao(mContext) : myDataDao;
                obj = myDataDao;

                //等价于下面的写法
                /*if (myDataDao == null) {
                    myDataDao = new MyDataDao(mContext);
                }
                obj = myDataDao;*/

                break;
            default:
                break;


        }
        return obj;
    }


}
