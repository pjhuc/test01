package main.pjhuc01.test10_thread;

public class Test {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"hello");
//        TestThread tt = new TestThread();
//        tt.start();
//        tt.setName("xioaxioa");
        TestThread02 t2 = new TestThread02();
        Thread t1 = new Thread(t2,"t2");
        t1.start();
    }

}
