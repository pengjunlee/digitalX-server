package com.digitalx.domain;

import java.io.Serializable;

/**
 * @author pengjunlee
 * @create 2019-09-03 9:30
 */
public class TmallRateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id; // 主键ID

    private String rateContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRateContent() {
        return rateContent;
    }

    public void setRateContent(String rateContent) {
        this.rateContent = rateContent;
    }
}
