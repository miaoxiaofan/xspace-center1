package com.xspace.commoncenter.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wmiao
 * @description TODO
 * @date 2020/5/24 22:05
 */

@Data
@Builder
public class Person implements Serializable {

    private String name;

    private int  age;

    private String address;
    private  transient int weight;

}
