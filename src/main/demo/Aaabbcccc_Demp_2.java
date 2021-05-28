package main.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Aaabbcccc_Demp_2 {

    public static void main(String[] args) {
        String str = "aacbbbb";
        System.out.println(getStr(str));
    }

    public static String getStr(String params) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i < params.length();i++) {
            Character c = params.charAt(i);
            String aa = c.toString();
            if(map.containsKey(aa)) {
                map.put(map.get(aa).toString(), map.get(aa)+1);
            }else {
                map.put(aa, 1);
            }
        }
        return mapToStr(map);
    }

    public static String mapToStr(HashMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> entryi : entries) {
            sb.append(entryi.getValue() + entryi.getKey());
        }
        return sb.toString();
    }

/*
    public static void main(String[] args){
        String arr = "lllldwwwwwkkkkkeeeekkcllslwooo";
        System.out.println(getStr(arr));
    }

    public static String getStr(String str){
        LinkedHashMap<Character, Integer> linkedMap = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(linkedMap.containsKey(str.charAt(i))){
                Integer c = linkedMap.get(str.charAt(i));
                c++;
                linkedMap.put(str.charAt(i), c);
            }else{
                linkedMap.put(str.charAt(i), 1);
            }
        }
        return getStrFromMap(linkedMap);
    }

    public static String getStrFromMap(LinkedHashMap linkMap){
        StringBuffer sb = new StringBuffer();
        for(Object key : linkMap.keySet()){
            sb.append(linkMap.get(key) + key.toString());
        }
        return sb.toString();
    }
*/

}
