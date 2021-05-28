package main.pjhuc01.test26;

import java.util.ArrayList;
import java.util.HashMap;

public class Test26 {
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("d");
        list.forEach(item -> System.out.println(item));
        
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.forEach((String key,String value) -> {
            System.out.println(key + "  " + value);
        });
    }
}
