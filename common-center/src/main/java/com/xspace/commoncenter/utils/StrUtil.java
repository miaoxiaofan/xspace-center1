package com.xspace.commoncenter.utils;

import java.util.Random;

public class StrUtil {

    private static final char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 生成随机串
     * @param length
     * @return
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        int range = CHARS.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS[random.nextInt(range)]);
        }
        return sb.toString();

    }
}
