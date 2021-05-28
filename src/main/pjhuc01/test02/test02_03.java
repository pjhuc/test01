package main.pjhuc01.test02;

import java.util.ArrayList;
import java.util.List;

public class test02_03 {

    public static void main(String[] args) {
        List list01 = new ArrayList();
        list01.add(0);
        List list02 = list01;
        System.out.println(list01.get(0) instanceof Integer);
        System.out.println(list02.get(0) instanceof Integer);
    }
}
