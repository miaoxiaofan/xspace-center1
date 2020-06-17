package com.xspace.commoncenter.reflection.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wmiao
 * @description TODO
 * @date 2020/6/16 23:12
 */
@Data
@Builder
public class Student {
    private String name;
    private Integer age;
    private Integer score;

    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
