package main.pjhuc01.test02;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompareTest2 {

    public static void main(String[] args){
        String str = "/app/sstf0/InterfaceZJK/data/UPP_file/111.json";
        String [] sz=str.split("/");
        System.out.println(sz[sz.length-1]);
        System.out.println(sz.length-1);
        System.out.println(sz[0]);
        System.out.println(sz[1]);
    }
    public static String[] split(String regex, String s) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        int index;
        for(index = 0; m.find(); ++index) {
            ;
        }

        return s.split(regex, index + 1);
    }



}
