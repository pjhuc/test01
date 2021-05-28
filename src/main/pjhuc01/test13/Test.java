package main.pjhuc01.test13;

/**
 * 用来描述节点类型
 */
public class Test {

    public static void main(String[] args) {
        LinkedTest lt = new LinkedTest();
        lt.add("zhangsan");
        lt.add("lisi");
        lt.add("wangwu");
//        System.out.println(lt.size());
//        System.out.println(lt.getHead());
//        System.out.println(lt.deleteHead());
//        System.out.println(lt.getHead());
//        System.out.println(lt.size());
//        lt.queryNode();
        lt.queryNode2();
    }
}
