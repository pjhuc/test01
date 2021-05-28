package main.pjhuc01.interface_test01;

public class Owner {

    public Animal an ;

    public Owner(Animal an) {
        this.an = an;
    }

    public void test() {
        an.run();
        an.sleep();
    }

}
