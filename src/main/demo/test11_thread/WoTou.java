package main.demo.test11_thread;

public class WoTou {

    private int number;
    private String name;

    public WoTou(int number,String name){
        this.number = number;
        this.name = name;
    }

    public String toString(){
        return name + "---WoTout:"+number;
    }

}
