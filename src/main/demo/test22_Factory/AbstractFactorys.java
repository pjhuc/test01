package main.demo.test22_Factory;

public class AbstractFactorys {
    
    public static void main(String[] args) {
        AbsFactory factory = new SuperFactory();
        Mask mask = factory.createMask();
        mask.print();
    }
}

interface AbsFactory{
    Phone createPhone();
    Mask createMask();
}

class SuperFactory implements AbsFactory {
    @Override
    public Phone createPhone() {
        return new iPhone();
    }
    @Override
    public Mask createMask() {
        return new N95();
    }
}

interface Phone{
    void print();
}

class iPhone implements Phone {
    @Override
    public void print() {
        System.out.println("iphone手机");
    }
}

interface Mask{
    void print();
}

class N95 implements Mask {
    @Override
    public void print() {
        System.out.println("N95口罩");
    }
}
