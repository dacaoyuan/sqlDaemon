package com.everyoo.localdata.sql.impl;

import com.everyoo.localdata.sql.bean.MyBean;

import java.util.ArrayList;

/**
 * Created by abc on 2017/3/8.
 */

public interface MyDataImpl {

    void insert(ArrayList<MyBean> beanArrayList);

    void update(String name, String price);

    void delete(String name);

    String queryPrice(String name);

    int queryCount();

    ArrayList<MyBean> queryAll();


}
