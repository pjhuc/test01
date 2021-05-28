package main.pjhuc01.test20;

import java.util.ArrayList;

/**
 *
 */

public class Test20 {
    
    static void print(ArrayList al) {
        al.add(2);
        al = new ArrayList();
        al.add(3);
        al.add(4);
    }
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        print(list);
        System.out.println(list);
    }

}
