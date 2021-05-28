package main.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class ListDemo02 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("D");

//        getSingle(list);
        System.out.println(list);
    }

    public static void getSingle(List<String> ls) {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.addAll(ls);
    }

}

/*

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("D");

        getSingle(list);
        System.out.println(list);
    }

    public static void getSingle(List<String> ls) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.addAll(ls);
        ls.clear();
        ls.addAll(lhs);
    }
*/

