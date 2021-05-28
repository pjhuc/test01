package main.pjhuc01.test10_thread;

public class TestThread02 implements Runnable{

    public void run(){
        System.out.println(Thread.currentThread().getName()+"NIHAO");
    }

}
