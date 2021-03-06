package com.example.greendaodemo2.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by 29083 on 2018/4/18.
 * <p>
 * 商品信息的表
 */

@Entity
public class Shop {
    //不能用int (autoincrement = true)表示主键会自增，如果false就会使用旧值
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String goodsId;

    private String name;

    // private String summary;

    // private String type;

    // private String price;

    private String addTime;

    //private int imageId;

    private int number;

    @Generated(hash = 1195576911)
    public Shop(Long id, String goodsId, String name, String addTime, int number) {
        this.id = id;
        this.goodsId = goodsId;
        this.name = name;
        this.addTime = addTime;
        this.number = number;
    }

    @Generated(hash = 633476670)
    public Shop() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


   

}
