package com.everyoo.localdata.sql.impl;


import com.everyoo.localdata.sql.bean.MyBean;

import java.util.ArrayList;

/**
 * Created by abc on 2017/3/8.
 */

public interface MyDataImpl {

    void insert(ArrayList<MyBean> beanArrayList);

    void insert(MyBean myBean);

    void update(String name, String price);

    void update2(String columnName, String columnValue);

    void update3(String queryColumnName, String queryColumnValue, String setColumnName, String setColumnValue);


    void delete(String name);

    int deleteAll();


    ArrayList<String> queryPrice(String name);

    String queryAuthor(String name, String price);

    long queryCount();

    ArrayList<MyBean> queryId(int id);

    ArrayList<MyBean> queryAll();


}
