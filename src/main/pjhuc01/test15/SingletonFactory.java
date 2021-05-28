package main.pjhuc01.test15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonFactory {

    private static final Map m = new HashMap();
    private static final SingletonFactory tf = new SingletonFactory();
    private SingletonFactory(){}

    public static SingletonFactory getSingletonFactory(){
        return tf;
    }

    public synchronized Object getObject(Class c) {
        if(m.containsKey(c.getName())) {
            return m.get(c.getName());
        }else{
            Object obj = null;
            try {
                obj = c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            m.put(c.getName(),obj);
            return obj;
        }
    }

}
