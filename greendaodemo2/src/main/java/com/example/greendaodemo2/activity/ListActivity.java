package com.example.greendaodemo2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.greendaodemo2.MyApplication;
import com.example.greendaodemo2.R;
import com.example.greendaodemo2.adapter.ListAdapter;
import com.example.greendaodemo2.bean.GoodsBean;
import com.example.greendaodemo2.dao.DaoSession;
import com.example.greendaodemo2.dao.ShopDao;
import com.example.greendaodemo2.data.Shop;
import com.example.greendaodemo2.view.EasySwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.right_title)
    TextView mRightTitle;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ListAdapter mAdapter;
    private DaoSession daoInstant;
    private ShopDao shopDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        mTitle.setText("项目列表");
        mRightTitle.setText("清空数据");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        daoInstant = MyApplication.getDaoInstant();
        shopDao = daoInstant.getShopDao();

        mRightTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopDao.deleteAll();
                mAdapter.setNewData(null);
            }
        });


        List<Shop> shops = shopDao.loadAll();
        if (shops != null && shops.size() > 0) {
            for (int i = 0; i < shops.size(); i++) {
                Log.i(TAG, "onCreate: id=" + shops.get(i).getId());
            }
        }


        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 3) {
            List<Shop> shops = shopDao.loadAll();
            mAdapter.setNewData(shops);
        }
    }

    private void initView() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        List<Shop> shops = shopDao.loadAll();
        mAdapter.setNewData(shops);

        mAdapter.addFooterView(getFooterView(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, AddAndUpdateActivity.class);
                intent.putExtra("flag", "add");
                //intent.putExtra("position", position + "");
                startActivityForResult(intent, 10);


            }
        }));


        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {


                EasySwipeMenuLayout easy_swipe_menu = (EasySwipeMenuLayout) mAdapter.getViewByPosition(mRecyclerView, position, R.id.easy_swipe_menu);


                switch (view.getId()) {
                    case R.id.content:
                        Log.i(TAG, "onItemClick: content");
                        Intent intent1 = new Intent(ListActivity.this, DetailsActivity.class);
                       /* intent1.putExtra("name", mAdapter.getItem(position).getName() + "");
                        intent1.putExtra("number", mAdapter.getItem(position).getNumber() + "");
                        intent1.putExtra("time", mAdapter.getItem(position).getAddTime() + "");*/
                        intent1.putExtra("position", position + 1 + "");
                        startActivity(intent1);


                        break;
                    case R.id.tv_update:
                        Log.i(TAG, "onItemClick: tv_update position=" + position);
                        Intent intent = new Intent(ListActivity.this, AddAndUpdateActivity.class);
                        intent.putExtra("position", position + 1 + "");
                        startActivityForResult(intent, 10);


                        easy_swipe_menu.resetStatus();

                        break;
                    case R.id.tv_delete:
                        Log.i(TAG, "onItemClick: tv_delete");
                        deleteAlertShow(position);
                        easy_swipe_menu.resetStatus();
                        break;
                }


            }
        });
    }

    private List<GoodsBean> getData() {
        List<GoodsBean> beanList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GoodsBean goodsBean = new GoodsBean();
            beanList.add(goodsBean);
        }
        return beanList;
    }

    public void deleteAlertShow(final int deletePosition) {
        Log.i(TAG, "deleteAlertShow: deletePosition=" + deletePosition);
        new AlertView("提示", "您确定要删除吗？", null, new String[]{"取消", "确定"}, null, this, AlertView.Style.Alert, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                switch (position) {
                    case 1:
                        shopDao.deleteByKey((long) (deletePosition + 1));
                        List<Shop> shops = shopDao.loadAll();
                        mAdapter.setNewData(shops);

                        break;
                }
            }
        }).show();
    }

    private View getFooterView(View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.foot_view_layout, (ViewGroup) mRecyclerView.getParent(), false);
        view.setOnClickListener(listener);
        return view;
    }


}
