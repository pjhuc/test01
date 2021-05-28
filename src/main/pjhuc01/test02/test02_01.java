package main.pjhuc01.test02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class test02_01 {

    public static void main(String[] args) {
        try {
            test("2020-01-01",30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    static void test(String d, int day) throws ParseException {
        Date date = new Date();
        long a = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long b = sdf.parse(d).getTime();
        int success = (int) ((b-a)/(1000*60*60*24)); //1000毫秒*60分钟*60秒*24小时 = 天
        System.out.println("距离"+d+"还有"+success+"天");
        if(success <= day){ //如果距离那天天数等于day

        }
    }

}
