package main.demo.test11_thread;

public class Consumer extends Thread{

    SyncStack ss;
    public Consumer(String name,SyncStack ss){
        super(name);
        this.ss = ss;
    }

    public void run(){
        for(int i = 1;i <= 10;i++){
            WoTou w = ss.pop();
            System.out.println(this.getName()+"-----"+w);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
