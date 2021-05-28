package main.pjhuc01.test16_reflex.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test16 {

    public static void test(Object obj) {
        Class clazz = obj.getClass();
        try {
            Object o = clazz.newInstance();
            //得到这种类型下的所有属性
            Field[] fs = clazz.getFields();
            fs = clazz.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                System.out.println("f.getName()=="+f.getName());
            }
            //得到这种类型下所有的方法
            Method[] ms = clazz.getMethods();
            ms = clazz.getDeclaredMethods();
            for (int i = 0; i < ms.length; i++) {
                Method m = ms[i];
                System.out.println(m.getName());
            }
            // 得到构造方法
            Constructor[] cs = clazz.getConstructors();
            for (int i = 0; i < cs.length; i++) {
                Constructor c = cs[i];
                System.out.println(c.getName());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Student stu = new Student();
        test(stu);
    }



}
