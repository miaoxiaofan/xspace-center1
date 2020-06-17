package com.xspace.commoncenter.exception;

/**
 * @author wmiao
 * @description TODO
 * @date 2020/5/24 23:15
 */
public class ReturnDemo1 {


    public  static String test(){


        try{
            System.out.println("try");

            throw new Exception("111");

        }catch (Exception e){
            System.out.println("Exception");
            return "3";
        }finally {
            System.out.println("final");
            return "2";
        }
    }




    public  static String test1(){


        try{
            System.out.println("try");

            throw new Exception("222");

        }catch (Exception e){
            System.out.println("Exception");
            return "3";
        }finally {
            System.out.println("final");
        }
    }


    public static void main(String[] args) {
        System.out.println(test1());
    }
}
