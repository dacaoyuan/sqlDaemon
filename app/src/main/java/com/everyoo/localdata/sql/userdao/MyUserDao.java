package com.everyoo.localdata.sql.userdao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.everyoo.localdata.sql.bean.MyBean;
import com.everyoo.localdata.sql.dao.MyDataDao;
import com.everyoo.localdata.sql.impl.MyDataImpl;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Created by abc on 2017/3/8.
 */

public class MyUserDao extends MyDataDao implements MyDataImpl {

    private static MyUserDao INSTANCE;
    private Context mContext;

    protected MyUserDao(Context context) {
        super(context);
    }

    public static MyUserDao getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyUserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyUserDao(context);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public void insert(ArrayList<MyBean> beanArrayList) {
        if (beanArrayList == null) {
            return;
        }
        db = getWritableDatabase();


        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            for (int i = 0; i < beanArrayList.size(); i++) {
                values.put("name", beanArrayList.get(i).getName());
                values.put("author", beanArrayList.get(i).getAuthor());
                values.put("price", beanArrayList.get(i).getPrice());
                values.put("pages", beanArrayList.get(i).getPages());
                db.insert(helper.TABLE_NAME, null, values);
                values.clear();
            }

        }
        closeDatabase();
    }

    @Override
    public void update(String name, String price) {
        db = getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("price", price);

            db.update(helper.TABLE_NAME, values, "name=?", new String[]{name});

        }
        closeDatabase();

    }

    @Override
    public void delete(String name) {
        db = getWritableDatabase();
        if (db.isOpen()) {
            //db.delete(helper.TABLE_NAME, "name = ?", new String[]{name});
            db.delete(helper.TABLE_NAME, null, null);
        }

        closeDatabase();

    }

    @Override
    public String queryPrice(String name) {
        db = getReadableDatabase();
        MyBean myBean = null;
        if (db.isOpen()) {
            myBean = new MyBean();
            String sql = "select price from " + helper.TABLE_NAME + " where name = ?";
            Cursor cursor = db.rawQuery(sql, new String[]{name});
            while (cursor.moveToNext()) {
                myBean.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            }
            cursor.close();
        }

        closeDatabase();
        return myBean.getPrice();
    }

    @Override
    public int queryCount() {
        db = getReadableDatabase();
        int count = 0;
        if (db.isOpen()) {
            String sql = "select * from " + helper.TABLE_NAME;
            Cursor cursor = db.rawQuery(sql, null);
            count = cursor.getCount();
            cursor.close();
        }
        closeDatabase();
        return count;
    }

    @Override
    public ArrayList<MyBean> queryAll() {
        db = getReadableDatabase();
        ArrayList<MyBean> arrayList = null;

        if (db.isOpen()) {
            arrayList = new ArrayList<>();
            String sql = "select * from " + helper.TABLE_NAME;
            Cursor cursor = db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                MyBean myBean = new MyBean();
                myBean.setName(cursor.getString(cursor.getColumnIndex("name")));
                myBean.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                myBean.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                myBean.setPages(cursor.getInt(cursor.getColumnIndex("pages")));
                arrayList.add(myBean);
            }
            cursor.close();
        }
        closeDatabase();
        return arrayList;
    }


    /**
     * 事务操作
     */
    public void transaction(ArrayList<MyBean> beanArrayList) {
        if (beanArrayList == null) {
            return;
        }
        db = getWritableDatabase();


        db.beginTransaction();//开启事务

        try{
            db.delete(helper.TABLE_NAME, null, null);
            ContentValues values = new ContentValues();
            for (int i = 0; i < beanArrayList.size(); i++) {
                values.put("name", beanArrayList.get(i).getName());
                values.put("author", beanArrayList.get(i).getAuthor());
                values.put("price", beanArrayList.get(i).getPrice());
                values.put("pages", beanArrayList.get(i).getPages());
                db.insert(helper.TABLE_NAME, null, values);
                values.clear();

                /*if (i == 1) {
                    throw new NullPointerException();
                }*/

            }

            db.setTransactionSuccessful();//事务已经执行成功
        }catch(Exception e){
             e.printStackTrace();
        }

        db.endTransaction();//结束事务

        closeDatabase();

    }




    public boolean deleteDatabases(Context context,String dbName){
        return context.deleteDatabase(dbName);
    }


}
