package com.example.greendaodemo2.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.greendaodemo2.R;
import com.example.greendaodemo2.data.Shop;

import java.util.List;

/**
 * Created by yuanpk on 2018/4/23  13:56
 * <p>
 * Description:TODO
 */

public class ListAdapter extends BaseQuickAdapter<Shop, BaseViewHolder> {


    public ListAdapter(@Nullable List<Shop> data) {
        super(R.layout.item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shop item) {
        helper.addOnClickListener(R.id.content);
        helper.addOnClickListener(R.id.tv_update);
        helper.addOnClickListener(R.id.tv_delete);

        helper.setText(R.id.tv_name, "名称:" + item.getName())
                .setText(R.id.tv_number, "数量：" + item.getNumber() + "")
                .setText(R.id.add_time, "添加时间:" + item.getAddTime());


    }
}
