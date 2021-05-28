package main.demo;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(111, "value01");
        map.put(222, "value02");
        map.put(333, "value03");

/*
        for(String ss : map.keySet()) {
            System.out.println(ss +"----"+ map.get(ss));
        }
*/
/*

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"----"+ entry.getValue());
        }
*/
/*
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() +"---"+ next.getValue());
        }
*/
        for(String value : map.values()) {
            System.out.println(value);
        }

    }
}

/*
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("key01","value01");
        map.put("key02","value02");
        map.put("key03","value03");

        for(String ss : map.keySet()) {
            System.out.println("key=" + ss + "   " + "value=" + map.get(ss));
        }

*/
/*        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(((Map.Entry) entry).getKey() +"   "+ ((Map.Entry) entry).getValue());
        }*//*


*/
/*        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"   "+ entry.getValue());
        }*//*


*/
/*        for(String ss : map.values()) {
            System.out.println(ss);
        }*//*


    }
*/
