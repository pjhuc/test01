package main.pjhuc01.test13;

/**
 * 用来描述节点类型
 */
public class Node {

    //能够存储数据的地方
    private Object obj;
    // 指向下一个节点类型
    private Node next;

    public Node(Object obj){
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
