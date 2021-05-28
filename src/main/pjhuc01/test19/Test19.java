package main.pjhuc01.test19;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test19 {
/*

    public static void main(String[] args) {
        Person19 aPerson =new Person19();
        Class  class1  = aPerson.getClass();
        try {
            Person19 c1 = aPerson.getClass().newInstance();
            Field field = class1.getDeclaredField("name");
            field.setAccessible(true);
            field.get(c1);
            System.out.println(field.get(c1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
/*

public static void main(String[] args) {
        Person19 aPerson =new Person19();
        Class  class1  = aPerson.getClass();
        try {
                Person19	c1 = aPerson.getClass().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
*/

    public static void main(String[] args) {
        Person19 aPerson =new Person19();
        Class  class1  = aPerson.getClass();
        try {
            Person19	c1 = aPerson.getClass().newInstance();

            Method aMethod  =Person19.class.getDeclaredMethod("setAge",int.class);
            Method bMethod =Person19.class.getDeclaredMethod("getAge");

            int age =(int)bMethod.invoke(c1);

            System.out.println(age);
            aMethod.invoke(c1,12);
            System.out.println(c1.getAge());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
