package main.pjhuc01.test18_reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test_18 {

    public void test(Object obj){
        Class s = obj.getClass();
        try {
            Object oo = s.newInstance();
            s.getDeclaredFields();
            //属性
//            Field[] fields = s.getFields();//只能拿到 public 修饰的属性
            Field[] fields = s.getDeclaredFields();// 能拿到所有属性（public、 private、protected 和 默认）
//            for(int i = 0;i < fields.length; i++) {
//                Field f = fields[i];
//                System.out.println(f.getName());
//            }
            //方法
            Method[] methods = s.getMethods();//getMethods可以获取本身类和其**所有父类的所有共有方法（public）
            Method[] declaredMethods = s.getDeclaredMethods();//declaredMethods只能获取当前类的方法（包访问权限＋public + private + protcted）
//            for (int i = 0; i < methods.length; i++) {
//                Method method = methods[i];
////                method.invoke(obj);
//                System.out.println(methods[i]);
//            }
            System.out.println("##########################################");
            for (int i = 0; i < declaredMethods.length; i++) {
                Method declaredMethod = declaredMethods[i];
//                declaredMethod.invoke(obj);
                System.out.println(declaredMethods[i]);
            }
            System.out.println("##########################################");
            //构造方法
//            Constructor[] cs = s.getConstructors();
//            for (int i = 0; i < cs.length; i++) {
//                System.out.println(cs[i]);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test_18 test_18 = new Test_18();
        test_18.test(new Student());
    }

}
