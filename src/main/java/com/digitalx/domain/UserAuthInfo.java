package com.digitalx.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用于返回给前端使用的用户信息封装类
 * @author pengjunlee
 * @create 2019-09-03 14:44
 */
public class UserAuthInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String nickName;

    private List<MenuEntity> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}
