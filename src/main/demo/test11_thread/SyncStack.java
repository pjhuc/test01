package main.demo.test11_thread;

public class SyncStack {

    //能够描述窝头 的数量
    int index = 0;
    //能头放窝头的数组
    WoTou[] ws = new WoTou[10];
    /**
     * 生产窝头的方法
     */
    public synchronized void push(WoTou w){
        while(index == ws.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //  如果消费者消费 窝头index 的变量的值  就会减少
        this.notify();
        //  继续生产
        ws[index++] = w;
    }

    /**
     * 消费者方法
     */
    public synchronized WoTou pop(){
        while(index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产者 生产窝头  就可以消费了
        this.notify();
        //
        index--;
        return ws[index];
    }


}
