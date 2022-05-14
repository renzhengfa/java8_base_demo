package com.kn20210413.多线程.多线程等待与唤醒案例;

import java.io.Serializable;
import java.util.Objects;

/*
包子类
 */
public class BaoZi implements Serializable {
    //皮
    private String pi;
    //陷
    private String xian;
    //默认没有包子
    private Boolean have = false;

    public BaoZi() {
    }

    public BaoZi(String pi, String xian) {
        this.pi = pi;
        this.xian = xian;
    }

    public BaoZi(String pi, String xian, Boolean have) {
        this.pi = pi;
        this.xian = xian;
        this.have = have;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public Boolean getHave() {
        return have;
    }

    public void setHave(Boolean have) {
        this.have = have;
    }

    @Override
    public String toString() {
        return "BaoZi{" +
                "pi='" + pi + '\'' +
                ", xian='" + xian + '\'' +
                ", have=" + have +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaoZi)) return false;
        BaoZi baoZi = (BaoZi) o;
        return Objects.equals(pi, baoZi.pi) &&
                Objects.equals(xian, baoZi.xian) &&
                Objects.equals(have, baoZi.have);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pi, xian, have);
    }
}
