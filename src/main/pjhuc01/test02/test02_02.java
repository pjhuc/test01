package main.pjhuc01.test02;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class test02_02 {

    public static void main(String[] args) {

        String str = "1,2,3,4,5,6,7,8,9,10";
        String[] strarr = str.split(",");
        for(int i = 0;i < strarr.length;i++){
            System.out.println("\r");
            System.out.print(strarr[i]);
        }

    }

}
