package main.demo.test11_thread;

/**
 * 生产者类
 */
public class Producer extends Thread{

    SyncStack ss;

    public Producer(String name,SyncStack ss){
        super(name);
        this.ss = ss;
    }

    public void run(){
        for(int i = 1;i <= 60;i++){
            WoTou w = new WoTou(i,this.getName());
            ss.push(w);
            System.out.println(w);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
