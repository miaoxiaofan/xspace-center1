package com.xspace.commoncenter.generics.entity;

import lombok.*;

import java.util.Objects;

/**
 * @author wmiao
 * @description 警车
 * @date 2020/6/17
 */

public class PoliceCar extends Car {
    private String policeNo;
    private String time;

    public String getPoliceNo() {
        return policeNo;
    }

    public void setPoliceNo(String policeNo) {
        this.policeNo = policeNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliceCar policeCar = (PoliceCar) o;
        return Objects.equals(policeNo, policeCar.policeNo) &&
                Objects.equals(time, policeCar.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policeNo, time);
    }
}
