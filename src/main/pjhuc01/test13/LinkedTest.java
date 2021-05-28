package main.pjhuc01.test13;

/**
 * 描述链表结构的
 */
public class LinkedTest {

    // 根节点的头
    private Node head;
    // 记录链表的大小
    private int index;

    //添加节点方法
    public void add(Object obj){
        // 创建了一个节点
        Node n  = new Node(obj);
        if(head == null) {
            // 第一次调用
            head = n;
        }else{
            // 让新节点指向 原来的头
            n.setNext(head);
            // 然后让head 变量变成新的 头
            head = n;
        }
        index++;
    }

    //查看链表的大小
    public int size() {
        return index;
    }

    //查看头结点
    public Object getHead() {
        return head.getObj();// 节点数据
    }

    public Object deleteHead() {
        Object obj = head.getObj();
        head = head.getNext();
        index--;
        return obj;
    }

    // 遍历方式1  循环
    public void queryNode() {
        System.out.println(head.getObj());
        if(head.getNext() != null){
            Node n = head.getNext();
            while(n != null){
                System.out.println(n.getObj());
                n = n.getNext();
            }
        }
    }
    // 递归方式遍历
    public void queryNode2(){
        System.out.println(head.getObj());
        this.queryNode3(head.getNext());
    }
    private void queryNode3(Node node){
        System.out.println(node.getObj());
        if(node.getNext() != null) {
            this.queryNode3(node.getNext());
        }
    }

}
