package com.xspace.commoncenter.generics.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

@Data
@Builder
public class GenericsClassDemo1 <T> {

    private T  body;

}
