package main.pjhuc01.test05;

public class Test0501 {

    public Test0501(){
        System.out.println(this.toString()+"构造函数");
    }
    public static void main(String[] args) {
        Test0501 t = new Test0501();
        Test0501 t2 = new Test0501();
        System.out.println(t.toString()+"第一个");
        System.out.println(t2.toString()+"第二个");
    }
}
