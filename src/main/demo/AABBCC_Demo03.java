package main.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class AABBCC_Demo03 {
    public static void main(String[] args) {
        String str = "aabbccc";
        System.out.println(getstr(str));
    }

    public static String getstr(String str) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0;i < str.length();i++) {
            Character cha = str.charAt(i);
            String charElm = cha.toString();
            if(map.containsKey(charElm)) {
                map.put(charElm, map.get(charElm) + 1);
            }else {
                map.put(charElm, 1);
            }
        }
        return exgMap(map);
    }

    public static String exgMap(Map map) {
        StringBuffer sb = new StringBuffer();
        for(Object key : map.keySet()) {
            sb.append(key + map.get(key).toString());
        }
        return sb.toString();
    }

}

