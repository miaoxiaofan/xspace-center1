package com.xspace.commoncenter.generics.entity;

import lombok.*;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class Car {
    public String type;
    public Double price;
    public String color;
    public String no;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
