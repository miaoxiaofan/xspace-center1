package com.xspace.commoncenter.reflection.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16
 */
@Data
@Builder
public class Person {
    private  String name;
    private String  address;
    private Integer age;
}
