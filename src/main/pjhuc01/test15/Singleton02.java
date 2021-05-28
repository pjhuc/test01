package main.pjhuc01.test15;

public class Singleton02 {

    private static Singleton02 sl02;

    private Singleton02(){}

    public synchronized static Singleton02 getSl02(){
        if(sl02 == null){
            sl02 = new Singleton02();
        }
        return sl02;
    }

}
