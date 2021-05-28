package main.demo;

/**
 * 遍历字符串的三种方法
 */
public class StrCutOut01 {

    public static void main(String[] args) {
        String str = "aacbbb";
        // 第一种
        char[] chars = str.toCharArray();
        for(char i : chars) {
            System.out.println(i);
        }

//        第二种
        for(int i = 0;i < str.length();i++) {
            System.out.println(str.charAt(i));
        }

        // 第三种
        for(int i = 0;i < str.length();i++) {
            System.out.println(str.substring(i,i+1));
        }
    }
}
