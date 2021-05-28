package main.pjhuc01.test22_Factory;

public class Test_22_01 {
    public static Product_21_01 createPorduct(String ss) {
        if("A".equals(ss)){
            return new ProductAA();
        }else{
            return new ProductBB();
        }
    }
    public static void main(String[] args) {
        Product_21_01 product = Test_22_01.createPorduct("B");
        product.print();
    }
}

interface Product_21_01 {
    public void print();
}

class ProductAA implements Product_21_01 {
    @Override
    public void print() {
        System.out.println("产品A");
    }
}
class ProductBB implements Product_21_01 {
    @Override
    public void print() {
        System.out.println("产品B");
    }
}


