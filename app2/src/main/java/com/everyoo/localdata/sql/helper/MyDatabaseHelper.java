package com.everyoo.localdata.sql.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.everyoo.localdata.sql.bean.MyBean;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abc on 2017/3/8.
 */

public class MyDatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "BookStore.db";
    public static final int DB_VERSION = 5;


    public static final String TABLE_NAME2 = "Category";
    public static final String CREATE_CATEGORY = "create table " + TABLE_NAME2
            + "(id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code text)";

    public MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            System.out.println("MyDatabaseHelper.onCreate");
            TableUtils.createTable(connectionSource, MyBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        System.out.println("MyDatabaseHelper.onUpgrade oldVersion=" + oldVersion + "  newVersion=" + newVersion);
        try {
            //升级处理
            switch (oldVersion) {
                case 1:
                    getDao(MyBean.class).executeRaw("alter table Book add column book_type varchar(20)");
                case 2:
                    // TableUtils.createTable(connectionSource, MyBean2.class);
                case 3:

                    /*经多次查阅资料，sqlLite的alter功能只是alter table的一个子集，只有部分功能，比如重命名表名，新增列到现有表中。不支持现有列的重命名，删除。
                    间接的办法：
                    比如说你要修改的表名是A，方法步骤如下：
                    1.新建一个临时表T，这个T和表A具有相同的列。
                    2.把A中所有的数据都通过insert语句插入到T中
                    3.删除表A
                    4.新建表A，这时表A的列名就是你想要的结果，以前想修改的列名是什么，这时候就定义成什么，以前要删除的某个列，那么在定义的时候就不定义它。*/
                    //getDao(MyBean.class).executeRaw("drop table Book");
                default:
                    break;
            }
            //如果做升级处理，显然这样处理比较暴力
            //TableUtils.dropTable(connectionSource, MyBean.class, true);
            //onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MyDatabaseHelper instance;

    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static MyDatabaseHelper getHelper(Context context) {
        if (instance == null) {
            synchronized (MyDatabaseHelper.class) {
                if (instance == null)
                    instance = new MyDatabaseHelper(context);
            }
        }
        return instance;
    }


    private Map<String, Dao> daos = new HashMap<>();

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = daos.get(clazz);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }


    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }


}
