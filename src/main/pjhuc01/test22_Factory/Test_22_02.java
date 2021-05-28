package main.pjhuc01.test22_Factory;

public class Test_22_02 {
    public static void main(String[] args) {
        BeanFactory aaaFactory = new BBactory();
        Product22_02 product = aaaFactory.createProduct();
        product.print();
    }
}

interface Product22_02 {
    public void print();
}

class ProductAA_22_02 implements Product22_02 {
    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductBB_22_02 implements Product22_02 {
    @Override
    public void print() {
        System.out.println("产品BB");
    }
}

interface BeanFactory {
    public Product22_02 createProduct();
}

class AAFactory implements BeanFactory {
    @Override
    public Product22_02 createProduct() {
        return new ProductAA_22_02();
    }
}

class BBactory implements BeanFactory {
    @Override
    public Product22_02 createProduct() {
        return new ProductBB_22_02();
    }
}