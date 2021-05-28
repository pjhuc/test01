package main.pjhuc01.test03;

public class Test {

    public static void main(String[] args) {
        //静态绑定，能确定test01()方法就是Employee这个类里面的
        Employee.test01();
        //动态绑定，通过对象确定是调用的哪个类中的方法
        //多态
        Employee e = new Employee();
        e = new Sale();
        e = new Manager();
        e.working();
    }
}
