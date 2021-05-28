package main.pjhuc01.test08;

public class test201209 {

    public static void testFor() {
        System.out.println("这是方法体start");
        String[] arr = {"111","222","333","444","555"};
        for (int i = 0; i < arr.length; i++) {
            if("333".equals(arr[i])) {
//                System.out.println("这是第三次");
                return;
            }
            System.out.println(arr[i]);
        }
        System.out.println("这是方法体end");
    }

    public static void main(String[] args) {
        testFor();
    }

}
