package com.example.greendaodemo2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.greendaodemo2.MyApplication;
import com.example.greendaodemo2.R;
import com.example.greendaodemo2.dao.DaoSession;
import com.example.greendaodemo2.dao.ShopDao;
import com.example.greendaodemo2.data.Shop;
import com.example.greendaodemo2.utils.StringUtils;
import com.example.greendaodemo2.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddAndUpdateActivity extends AppCompatActivity {
    private static final String TAG = "AddAndUpdateActivity";
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private String flag;

    @BindView(R.id.number)
    EditText mNumber;
    @BindView(R.id.time)
    EditText time;

    @BindView(R.id.shop_name)
    EditText shop_name;

    @BindView(R.id.ok)
    Button mOk;

    //private String id;
    private String goods_id;
    private Shop shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_update);
        ButterKnife.bind(this);

        DaoSession daoInstant = MyApplication.getDaoInstant();
        final ShopDao shopDao = daoInstant.getShopDao();


        flag = getIntent().getStringExtra("flag");
        if (flag != null && flag.equals("add")) {
            mTitle.setText("添加");
        } else {
            mTitle.setText("修改");


            //id = getIntent().getStringExtra("position");
            //Log.i(TAG, "onCreate: id=" + id);
            //Shop shop = shopDao.load(Long.parseLong(id));


            goods_id = getIntent().getStringExtra("goods_id");
            Log.i(TAG, "onCreate: goods_id=" + goods_id);
            shop = shopDao.queryBuilder()
                    .where(ShopDao.Properties.GoodsId.eq(goods_id))
                    .unique();


            mNumber.setText(shop.getNumber() + "");
            time.setText(shop.getAddTime());
            shop_name.setText(shop.getName());


        }


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLegal()) {


                    if (flag != null && flag.equals("add")) {
                        Shop shop1 = new Shop();
                        shop1.setGoodsId(StringUtils.getUUID());
                        shop1.setAddTime(strTime);
                        shop1.setName(strShop_name);
                        shop1.setNumber(Integer.parseInt(strNumber));
                        shopDao.insertOrReplace(shop1);
                    } else {
                        //shop1.setId(Long.parseLong(id));
                        shop.setAddTime(strTime);
                        shop.setName(strShop_name);
                        shop.setNumber(Integer.parseInt(strNumber));
                        shopDao.update(shop);
                    }


                    ToastUtil.show("提交成功");
                    setResult(3);
                    finish();

                }
            }
        });


    }

    private String strShop_name;
    private String strNumber;
    private String strTime;

    private boolean isLegal() {
        strShop_name = shop_name.getText().toString().trim();
        strNumber = mNumber.getText().toString().trim();
        strTime = time.getText().toString().trim();

        if (TextUtils.isEmpty(strShop_name)) {
            ToastUtil.show("名称不能为空");
            return false;
        }


        if (TextUtils.isEmpty(strNumber)) {
            ToastUtil.show("数量不能为空");
            return false;
        }

        if (TextUtils.isEmpty(strTime)) {
            ToastUtil.show("时间不能为空");
            return false;
        }


        return true;

    }
}
