package main.demo;


import java.util.Random;

/**
 * 产生随机字符串，长度由参数指定。
 * @return 已产生的字符串
 * @author Code_小生
 */

public class Random_Demo01 {

    public static String getRandString(int length) {
        String charList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String rev = "";
        Random f = new Random();
        for(int i = 0;i < length;i++) {
            rev += charList.charAt(Math.abs(f.nextInt())%charList.length());
    }
        return rev;
    }
}

/*

    public static void main(String[] args) {
        System.out.println(getRandString(10));
    }

    public static String getRandString(int length) {
        String charList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String rev = "";
        Random f = new Random();
        for(int i=0;i<length;i++) {
            rev += charList.charAt(Math.abs(f.nextInt())%charList.length());
        }
        return rev;
    }
*/

