package main.pjhuc01.test15;

public class Singleton {

    private static final Singleton sl = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return sl;
    }

}
