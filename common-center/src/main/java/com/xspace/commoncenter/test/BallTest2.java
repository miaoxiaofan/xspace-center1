package com.xspace.commoncenter.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wmiao
 * @description
 * @date 2020/6/4
 */

public class BallTest2 {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("第"+(i+1)+"次："+test());
        }

    }


    public static String test() {
        int[] pool = new int[35];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            list.add(i);
        }
        int[] pool2 = new int[12];
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            list2.add(i);
        }

        int num = 0;
        Random random = new Random();
        String msg = "";
        int[] result = new int[7];
        while ((num) < 7) {
            if (num > 4) {
                int randIndex = random.nextInt(12 - num);
                result[num] = list2.get(randIndex);
                list2.remove(randIndex);
            } else {
                int randIndex = random.nextInt(35 - num);
                result[num] = list.get(randIndex);
                list.remove(randIndex);
            }
            num++;
        }


        //排序

        for (int i = 0; i < result.length-2; i++) {
            for (int j = i + 1; j < result.length-2; j++) {
                int temp;
                if (result[i] > result[j]) {
                    temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        int temp;
        if (result[5] > result[6]) {
            temp = result[5];
            result[5] = result[6];
            result[6] = temp;
        }


        String resultMsg="";
        for (int i = 0; i < result.length; i++) {
            resultMsg=resultMsg+result[i]+",";
        }


        return resultMsg;
    }
}
