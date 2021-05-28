package main.pjhuc01.interface_test01;

public class Test {

    public static void main(String[] args) {

        Dog1 dog1 = new Dog1();
        Horse1 horse1 = new Horse1();
        Pag1 pag1 = new Pag1();

        Owner owner = new Owner(pag1);
        owner.test();


    }

}
