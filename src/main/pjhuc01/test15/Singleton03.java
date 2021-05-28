package main.pjhuc01.test15;

import java.util.ArrayList;
import java.util.List;

public class Singleton03 {

    private static final List list = new ArrayList();

    private Singleton03(){}

    public synchronized static Singleton03 getSl03(){
        if(list.isEmpty()) {
            Singleton03 sl03 = new Singleton03();
            list.add(sl03);
            return sl03;
        }else {
            return (Singleton03) list.get(0);
        }
    }

}
