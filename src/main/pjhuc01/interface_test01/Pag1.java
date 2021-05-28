package main.pjhuc01.interface_test01;

public class Pag1 implements Animal{

    @Override
    public void run() {
        System.out.println("猪在跑");
    }

    @Override
    public void sleep() {
        System.out.println("猪在睡觉");
    }
}
