package main.pjhuc01.test09;

public class TestThread0902 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 5;i++){
            System.out.println("TestThread0902");
        }
    }
}
