package com.example.greendaodemo2.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by 29083 on 2018/4/18.
 * <p>
 * 商品信息的表
 */

@Entity
public class Shop {

    @Id(autoincrement = false)
    private Long id;

   /* @Unique
    private String goodsId;*/

    private String name;

    // private String summary;

    // private String type;

    // private String price;

    private String addTime;

    //private int imageId;

    private int number;

    @Generated(hash = 774330162)
    public Shop(Long id, String name, String addTime, int number) {
        this.id = id;
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
