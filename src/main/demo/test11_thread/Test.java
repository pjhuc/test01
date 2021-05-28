package main.demo.test11_thread;

public class Test {

    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer pro = new Producer("zhangsan",ss);
        Consumer c = new Consumer("lisi",ss);
        Consumer c2 = new Consumer("wangwu",ss);
        pro.start();
        c.start();
        c2.start();

    }

}
