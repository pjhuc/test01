package main.pjhuc01.test22_Factory;

import java.util.LinkedList;

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factory = new HuaWeiFactory();
        Phones phones = factory.createPhones();
        phones.print();
    }
}
interface Phones{
    void print();
}

class iPhones implements Phones{
    @Override
    public void print() {
        System.out.println("iphone手机");
    }
}
class HuaWai implements Phones{
    @Override
    public void print() {
        System.out.println("华为手机");
    }
}
interface Factory{
    Phones createPhones();
}

class iPhoneFactory implements Factory{
    @Override
    public Phones createPhones() {
        return new iPhones();
    }
}
class HuaWeiFactory implements Factory{
    @Override
    public Phones createPhones() {
        return new HuaWai();
    }
}

/*
//Collection 接口中
//ArrayList实现了Collection 生产适合 ArrayList 的对象
//LinkedList 实现了Collection 生产适合 LinkedList 的对象
//生产迭代器对象
Iterator<E> iterator();

// ArrayList 生产适合自己
}的 iterator
public Iterator<E> iterator() {
    return new ArrayList.Itr();

// Itr 就是生产出的产品
private class Itr implements Iterator<E> {}
*/
