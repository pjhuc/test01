package main.pjhuc01.test27;

public class ProxyPattern {
    public static void main(String[] args) {
        new RealSubjectProxy().doWork();
    }
}
interface Subject{
    void doWork();
}
class RealSubject implements Subject{
    @Override
    public void doWork() {
        System.out.println("实际的doWork方法");
    }
}
class RealSubjectProxy implements Subject{
    private RealSubject subject;
    
    public RealSubjectProxy() {
        try {
            this.subject = (RealSubject) this.getClass().getClassLoader().loadClass("main.pjhuc01.test27.RealSubject").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void connect(){
        System.out.println("建立连接");
    }
    public void log(){
        System.out.println("日志记录");
    }
    @Override
    public void doWork() {
        connect();
        subject.doWork();
        log();
    }
}
