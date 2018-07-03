package com.example.greendaodemo.sql.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by yuanpk on 2017/12/19.
 */


@Entity
public class Shop {

    //表示为购物车列表
    public static final int TYPE_CART = 0x01;
    //表示为收藏列表
    public static final int TYPE_LOVE = 0x02;

    //不能用int (autoincrement = true)表示主键会自增，如果false就会使用旧值
    @Id(autoincrement = true)
    private Long id;
    //商品名称
    @Unique
    @Property(nameInDb = "name")
    private String name; //@Unique：该属性值必须在数据库中是唯一值(主键)
    //商品价格
    @Property(nameInDb = "price")  //@Property：可以自定义字段名，注意外键不能使用该属性
    private String price;
    //已售数量
    @Property(nameInDb = "sell_num")
    private int sell_num;
    //图标url
    @Property(nameInDb = "image_url")
    private String image_url;
    //商家地址
    @Property(nameInDb = "address")
    private String address;
    //商品列表类型
    @Property(nameInDb = "type")
    private int type;

    @Generated(hash = 1304458862)
    public Shop(Long id, String name, String price, int sell_num, String image_url,
                String address, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sell_num = sell_num;
        this.image_url = image_url;
        this.address = address;
        this.type = type;
    }

    public Shop(String name, String price, int sell_num, String image_url,
                String address, int type) {
        this.name = name;
        this.price = price;
        this.sell_num = sell_num;
        this.image_url = image_url;
        this.address = address;
        this.type = type;
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getSell_num() {
        return this.sell_num;
    }
    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
}


