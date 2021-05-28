package main.pjhuc01.test22_Factory;

public class Test22_03 {
    
    public static void main(String[] args) {
        SuperFactoryaa superFactory = new SuperFactoryaa();
        Mask2203 mask2203 = superFactory.createMask2203();
        mask2203.print();
    }

}
interface AbsFactory2203{
    Mask2203 createMask2203();
    Phone2203 creeatePhone2203();
}

interface Mask2203{
    void print();
}
class  SuperFactoryaa implements AbsFactory2203{
    
    @Override
    public Mask2203 createMask2203() {
        return new N952203();
    }
    
    @Override
    public Phone2203 creeatePhone2203() {
        return new iPhone2203();
    }
}
class N952203 implements Mask2203{
    @Override
    public void print() {
        System.out.println("N95口罩");
    }
}
interface Phone2203{
    void print();
}
class iPhone2203 implements Phone2203{
    @Override
    public void print(){
        System.out.println("苹果手机");
    }
}
