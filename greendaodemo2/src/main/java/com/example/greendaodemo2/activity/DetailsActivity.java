package com.example.greendaodemo2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.greendaodemo2.MyApplication;
import com.example.greendaodemo2.R;
import com.example.greendaodemo2.dao.DaoSession;
import com.example.greendaodemo2.dao.ShopDao;
import com.example.greendaodemo2.data.Shop;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @BindView(R.id.number)
    EditText mNumber;
    @BindView(R.id.time)
    EditText mtime;

    @BindView(R.id.shop_name)
    EditText shop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mTitle.setText("项目详情");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DaoSession daoInstant = MyApplication.getDaoInstant();
        final ShopDao shopDao = daoInstant.getShopDao();


        String id = getIntent().getStringExtra("position");
        //Shop shop = shopDao.loadByRowId(Long.parseLong(id));


        String goods_id = getIntent().getStringExtra("goods_id");
        Shop shop = shopDao.queryBuilder()
                .where(ShopDao.Properties.GoodsId.eq(goods_id))
                .unique();



        mNumber.setText(shop.getNumber() + "");
        mtime.setText(shop.getAddTime());
        shop_name.setText(shop.getName());


    }
}
