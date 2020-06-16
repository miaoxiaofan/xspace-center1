package com.xspace.commoncenter.test;

import java.util.Random;

/**
 * @author wmiao
 * @description
 * @date 2020/6/4
 */

public class BallTest {
    public static void main(String[] args) {
        int[] no1=new int[]{1,3,2,4,5};
        int[] no2=new int[]{7,9,6,8,5};
        int[] no3=new int[]{20,19,17,18,22};
        int[] no4=new int[]{29,23,25,26,27};
        int[] no5=new int[]{35,34,33,32,30};
        int[] no6=new int[]{2,1,3,4,5};
        int[] no7=new int[]{12,11,10,7,9};

        int[][] arrayss=new int[7][];
        arrayss[0]=no1;
        arrayss[1]=no2;
        arrayss[2]=no3;
        arrayss[3]=no4;
        arrayss[4]=no5;
        arrayss[5]=no6;
        arrayss[6]=no7;

        Random random=new Random();

        int times=5;
        for(int m=0;m<times;m++){
            String msg="";
            for(int i=0;i<7;i++){
                int index=random.nextInt(5);
                msg=msg+","+arrayss[i][index];
            }
            System.out.println("第"+(m+1)+"次："+msg);
        }
       String sss="02 09 16 23 27 03 08";

    }
}
