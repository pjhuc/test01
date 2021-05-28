package main.pjhuc01.test12;

public class Test {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push("zhangsna");
        s.push("wangwu");
        s.push("lisi");
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }

}
