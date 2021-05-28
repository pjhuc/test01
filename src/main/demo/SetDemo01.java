package main.demo;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SetDemo01 {

    public static void main(String[] args) {
        aa(3);
    }

    public static void aa(int n) {
        LinkedHashSet set = new LinkedHashSet();
        Random random = new Random();
        while(set.size() < n) {
            int i = random.nextInt(n);
            set.add(i);
        }
        System.out.println(Arrays.toString(set.toArray()));
    }

}
/*
    public static void main(String[] args) {
        aa(10);
    }
    //利用Set集合不重复的特点,我们可以Random一个数,往Set中插入数据,直到Set集合的大小满足我们要的数量
    public static void aa(int n){
        Set r = new LinkedHashSet(n);
        Random random = new Random();
        while (r.size() < n ) {
            int i = random.nextInt(n );
            r.add(i);
        }
        System.out.println(Arrays.toString(r.toArray()));
    }
*/
