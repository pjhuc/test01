package main.pjhuc01.test09;

public class TestThread0901 extends Thread{

    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+"TestThread0901");
        }
    }

}
