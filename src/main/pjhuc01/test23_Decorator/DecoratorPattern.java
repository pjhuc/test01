package main.pjhuc01.test23_Decorator;

public class DecoratorPattern {
    
    public static void main(String[] args) {
        new MyRobot(new FirstRobot()).doMoreThing();
    }
}
interface Robot{
    void doSomeThing();
}
class FirstRobot implements Robot{
    @Override
    public void doSomeThing(){
        System.out.println("乒乓球");
        System.out.println("羽毛球");
    }
}
class MyRobot implements Robot{
    private Robot robot;
    public MyRobot(Robot myRobot){
        this.robot = myRobot;
    }
    @Override
    public void doSomeThing() {
        robot.doSomeThing();
    }
    public void doMoreThing(){
        robot.doSomeThing();
        System.out.println("哦篮球");
        System.out.println("排球");
    }
}
