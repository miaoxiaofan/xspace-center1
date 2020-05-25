package com.xspace.commoncenter.lock;

import java.math.BigDecimal;

/**
 * @author wmiao
 * @description
 * @date 2019/8/21
 */

public class TTT {
    public static void main(String[] args) {
        BigDecimal range=new BigDecimal(100);
        BigDecimal bigDecimal = new BigDecimal(100.0 * 1 / 166).setScale(1, BigDecimal.ROUND_DOWN);
        range= range.subtract(bigDecimal);
        System.out.println(range.toString());
    }
}
