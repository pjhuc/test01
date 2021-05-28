package main.demo.test23_Decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doMoreThing();
    }
}

interface Robot{
    void doSomeThing();
}

class FirstRobot implements Robot {
    @Override
    public void doSomeThing() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class RobotDecorator implements Robot {
    private Robot robot;
    public RobotDecorator(Robot robot){
        this.robot = robot;
    }
    @Override
    public void doSomeThing() {
        robot.doSomeThing();
    }
    public void doMoreThing(){
        robot.doSomeThing();
        System.out.println("跳舞、拖地");
    }
}
