package com.digitalx.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 14:48
 */
public class CommentGoodsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String shop;

    private String imgUrl;

    private String goodsNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
