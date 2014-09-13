package org.yywang.app.model;

import java.util.Date;

/**
 * 电视
 *
 * @author yywang
 */
public class Television {

    /**
     * 电视品牌
     */
    private String brand;

    /**
     * 电视型号
     */
    private String model;

    /**
     * 电视状态
     */
    private TVStatus tvStatus;

    /**
     * 上次使用时间
     */
    private Date lastUseTime;

    public Television() {

    }

    public Television(String brand, String model, TVStatus tvStatus) {
        this.brand = brand;
        this.model = model;
        this.tvStatus = tvStatus;
    }

    @Override
    public String toString() {
        return this.brand + "  " + this.model + "  " + tvStatus.getDes();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TVStatus getTvStatus() {
        return tvStatus;
    }

    public void setTvStatus(TVStatus tvStatus) {
        this.tvStatus = tvStatus;
    }

    public Date getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Date lastUseTime) {
        this.lastUseTime = lastUseTime;
    }
}
