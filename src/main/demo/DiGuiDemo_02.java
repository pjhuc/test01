package main.demo;

/**
 * 递归demo
 * 输出什么？
 */
public class DiGuiDemo_02 {

    public static void main(String[] args) {
        mystery(1234);
    }
    //precondition:  x &gt;=0
    public static void mystery (int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
}
