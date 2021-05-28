package main.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class JieCheng {

    // n的阶乘
    public static void main(String[] args) {
        int n = 5;
        System.out.println(rec(n));
    }

    public static int rec(int n) {
        if(n == 1) {
            n = 1;
        }else {
            n = n * rec(n - 1);
        }
        return n;
    }

}
