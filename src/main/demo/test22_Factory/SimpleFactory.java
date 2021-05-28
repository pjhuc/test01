package main.demo.test22_Factory;

public class SimpleFactory {
    
    /**
     * 简单工厂模式
     */
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.print();
    }
}

abstract class Product {
    public abstract void print();
}

class ProductA extends Product {
    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductB extends Product {
    @Override
    public void print() {
        System.out.println("产品B");
    }
}