package main.pjhuc01.test20;

import java.math.BigDecimal;

/**
 * 递归demo
 * 输出什么？
 */
public class Test20_03 {

    public static void main(String[] args) {
        mystery(1234);
    }
    //precondition:  x &gt;=0
    public static void mystery (int x) {
        BigDecimal bd = new BigDecimal(666);
        BigDecimal bd2 = new BigDecimal(111);
        System.out.println(bd.compareTo(bd2) == 0);
    }
}
