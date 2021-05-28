package main.pjhuc01.test24_Adapter;

public class AdapterPattern {
    public static void main(String[] args) {
        Traslator adapter = new Adapter();
        adapter.output();
    }
}
class AC220 {
    public int acPut(){
        int AC220 = 220;
        System.out.println("输出"+AC220+"V");
        return  AC220;
    }
}
interface Traslator{
    public int output();
}
class Adapter implements Traslator{
    private AC220 ac220 = new AC220();
    @Override
    public int output() {
        int originalNum = ac220.acPut();
        //简化的转换器,目的是输出5V电流
        int resultNum = originalNum/44;
        System.out.println("适配器转换后的电压"+resultNum+"V");
        return resultNum;
    }
}