package com.example.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.greendaodemo.sql.GreenDaoManager;
import com.example.greendaodemo.sql.bean.Book;
import com.example.greendaodemo.sql.bean.Shop;
import com.example.greendaodemo.sql.dao.BookDao;
import com.example.greendaodemo.sql.dao.DaoSession;
import com.example.greendaodemo.sql.dao.ShopDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.create)
    Button create;
    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.btn_queryAll)
    Button btnQueryAll;
    @BindView(R.id.btn_all)
    Button btnAll;
    @BindView(R.id.btn_insertOrReplace)
    Button btnInsertOrReplace;
    @BindView(R.id.query)
    Button query;


    private DaoSession daoSession;
    private ShopDao shopDao;
    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        daoSession = GreenDaoManager.getInstance().getmDaoSession();
        shopDao = daoSession.getShopDao();
        //shopDao = DbManager.mDaoSession.getShopDao();

        bookDao = daoSession.getBookDao();


    }

    @OnClick({R.id.create, R.id.btn_insert, R.id.btn_delete, R.id.btn_update,
            R.id.btn_queryAll, R.id.btn_all, R.id.btn_insertOrReplace, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create:

                break;
            case R.id.btn_insert:
                Shop shop5 = new Shop("测试1", "22", 22, "imageUrl", "山东省", 1);
                shopDao.insert(shop5);

                Shop shop6 = new Shop("测试2", "22", 22, "imageUrl", "山东省", 362);
                shopDao.insert(shop6);


                break;
            case R.id.btn_insertOrReplace://这个比较常用


                bookDao.insertOrReplace(new Book("1", "ypk", "sds"));


                Shop shop1 = new Shop("测试1", "ypk", 221, "imageUrl", "山东省", 111);
                Shop shop2 = new Shop("测试2", "22", 22, "imageUrl", "山东省2", 2);
                Shop shop3 = new Shop("测试3", "223", 223, "imageUrl", "山东省3", 111);
                shopDao.insertOrReplace(shop1);
              /*  List<Shop> list = new ArrayList<>();
                list.add(shop1);
                list.add(shop2);
                list.add(shop3);
                shopDao.insertOrReplaceInTx(list);*/

                //Shop shop1 = new Shop("测试1", "22", 22, "imageUrl", "山东省", 1);
                //shopDao.insertOrReplace(shop1);

                break;

            case R.id.btn_delete:
                //shopDao.deleteByKey(2L);
                shopDao.delete(new Shop(2l, "测试2", "22", 22, "imageUrl", "山东省2", 2));


                break;
            case R.id.btn_all:
                shopDao.deleteAll();
                break;


            case R.id.btn_update:
                //Shop shop4 = new Shop(3l,"测试3", "22", 22, "imageUrl", "山东省3", 100);
                //shopDao.update(shop4);

                break;
            case R.id.btn_queryAll:
                //List<Shop> shopList = shopDao.loadAll();
                List<Shop> shopList = shopDao.queryBuilder().list();
                for (Shop shop : shopList) {
                    Log.i(TAG, "onViewClicked:shop= " +
                            shop.getId() + " " +
                            shop.getName() + " " +
                            shop.getPrice() + " " +
                            shop.getSell_num() + " " +
                            shop.getImage_url() + " " +
                            shop.getType());
                }

                List<Book> booksList = bookDao.queryBuilder().list();
                for (Book book : booksList) {
                    Log.i(TAG, "onViewClicked:shop= " +
                            book.getId() + " " +
                            book.getBookname() + " " +
                            book.getBookAddress() + " " +
                            book.getBookId());
                }

                break;

            case R.id.query:

                long count = shopDao.queryBuilder().count();
                Log.i(TAG, "onViewClicked: 数据库中数据的个数 count=" + count);

                //查询type字段 为111的数据集合
                // List<Shop> shops = shopDao.queryBuilder().where(ShopDao.Properties.Type.eq(111)).list();
                List<Shop> shops = shopDao.queryBuilder().where(ShopDao.Properties.Type.eq(111), ShopDao.Properties.Sell_num.eq(223)).list();
                for (Shop shop : shops) {
                    Log.i(TAG, "onViewClicked:shop= " +
                            shop.getId() + " " +
                            shop.getName() + " " +
                            shop.getPrice() + " " +
                            shop.getSell_num() + " " +
                            shop.getImage_url() + " " +
                            shop.getType());
                }


                break;
        }
    }


}
