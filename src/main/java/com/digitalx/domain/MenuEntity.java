package com.digitalx.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 14:48
 */
public class MenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String path;

    private String icon;


    private List<MenuEntity> children;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }
}
