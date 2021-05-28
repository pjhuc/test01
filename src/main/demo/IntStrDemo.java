package main.demo;

public class IntStrDemo {

    public static void main(String[] args) {
        //int 转 String 三种方法
        Integer aa = 111;
        System.out.println(String.valueOf(aa));
        System.out.println(Integer.toString(aa));
        System.out.println(aa+"");
        // String 转 int
        String cc = "222";
        int i = Integer.parseInt(cc);
        int j = Integer.valueOf(cc).intValue();
    }

}
