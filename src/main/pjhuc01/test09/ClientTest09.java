package main.pjhuc01.test09;

import java.lang.reflect.Field;

public class ClientTest09 {

    public void test(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientTest09  test");
        }
    }

    public static void main(String[] args){
        System.out.println("nihao");
////        ClientTest09 ct = new ClientTest09();
//        ct.test();
        TestThread0901 t1 = new TestThread0901();
        TestThread0901 t2 = new TestThread0901();
        TestThread0902 t3 = new TestThread0902();
        t1.start();
        t2.start();
        Thread tt = new Thread(t3);
        System.out.println(tt);
        tt.start();
        System.out.println("hello");
    }
}
