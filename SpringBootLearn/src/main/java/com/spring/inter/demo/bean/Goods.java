package com.spring.inter.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/16 15:43
 **/
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "img_url")
    private String imgUrl;

    //是否常用 1常用 0 不常用
    @Column(name = "is_often")
    private String isOften;

    //商品类型 0 汉堡 1 饮料 2 小食 3 套餐
    @Column(name = "type")
    private String type;

    public Goods() {
    }

    public Goods(String name, Long price, String imgUrl, String isOften, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.isOften = isOften;
        this.type = type;
    }

    public Goods(long id,String name, Long price, String imgUrl, String isOften, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.isOften = isOften;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIsOften() {
        return isOften;
    }

    public void setIsOften(String isOften) {
        this.isOften = isOften;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
