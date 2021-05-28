package main.pjhuc01.test12;

public class MyStack {

    private Object objs[] = new Object[5];
    private int index = 0;

    public void push(Object obj){
        if(index == objs.length){
            Object objs2[] = new Object[objs.length*2];
            for(int i = 0;i < objs.length;i++){
                objs2[i] = objs[i];
            }
            objs = objs2;
        }
        objs[index++] = obj;
    }

    //
    public int size() {
        return index;
    }

    //产看  栈顶
    public Object peek() {
        return objs[index - 1];
    }

    //移除栈顶
    public Object pop(){
        return objs[--index];
    }

}
