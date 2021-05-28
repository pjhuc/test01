package main.pjhuc01.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        new ClientOO("127.0.0.1",8080,"a");//服务器ip  服务器端口    自身编号
    }
}
class  ClientOO{
    private String path;
    private int port;
    private String name;
    private Scanner sca= new Scanner(System.in);
    private  DataInputStream in;
    private  DataOutputStream out;
    public ClientOO(String path,int port,String name){
        this.path=path;
        this.port=port;
        this.name=name;
        try {
            Socket s=new Socket(path,port);
            this.in=new DataInputStream(s.getInputStream());
            this.out=new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        send();

        hhhhh();
    }
    public void send(){
        String s = null;
        try {
            out.writeUTF(name);//  1
            out.flush();


            s=in.readUTF();//2
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("在线列表："+s);
    }
    public  void hhhhh(){
        while(true){
            System.out.println("聊天请输入 l  文件传输请输入   w  退出 请输入  t ");
            String str=sca.next();
            if(str.equalsIgnoreCase("l")){
                try {
                    out.writeUTF(str);
                    out.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("====================");
                MyServerReader1 hhhh = new  MyServerReader1(in);
                MyServerWriter1 wwwwww = new MyServerWriter1(out,str);
                hhhh.start();
                wwwwww.start();
                try {
                    wwwwww.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(str.equalsIgnoreCase("w")){
                try {
                    out.writeUTF(str);
                    out.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                MyServerReader1 hhhh = new  MyServerReader1(in);
                MyServerWriter1 wwwwww = new MyServerWriter1(out,str);
                hhhh.start();
                wwwwww.start();
                try {
                    wwwwww.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if(str.equalsIgnoreCase("t")){
                try {
                    out.writeUTF(str);
                    out.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("你退出系统");
                System.exit(0);
            }

        }
    }
}
class MyServerReader1 extends Thread {
    private DataInputStream dis;
    private String str;
    public MyServerReader1(DataInputStream dis) {
        this.dis = dis;

    }

    public void run() {
        try {
            str=dis.readUTF();
            if(str.equalsIgnoreCase("l")){
                liaotian();
            }
            if(str.equalsIgnoreCase("w")){
                wenjian();
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void wenjian (){

        String fileName;
        try {
            String[] hhh = dis.readUTF().split("=====");
            fileName =hhh[1] ;
            File  f= new File("F:\\"+fileName);
            OutputStream os= new FileOutputStream(f);
            byte[] b= new byte[1024];
            int i=0;
            while((i=dis.read(b))!=-1){
                os.write(b, 0, i);

            }
            os.close();
            System.out.println(hhh[0]+"给你传输了文件："+fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public  void liaotian(){
        String info;
        try {
            while (true) {
                // 如果对方，即客户端没有说话，那么就会阻塞到这里，
                // 这里的阻塞并不会影响到其他线程
                info = dis.readUTF();
                // 如果状态有阻塞变为非阻塞，那么就打印接受到的信息
                System.out.println("对方说: " + info);
                if (info.equals("bye")) {
                    System.out.println("对方下线，选着其他好友!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 从键盘获得输入流并写入信息到客户端
class MyServerWriter1 extends Thread {
    private DataOutputStream dos;
    private Scanner sc;
    private String str;
    public MyServerWriter1(DataOutputStream dos,String s) {
        this.dos = dos;
        this.str=s;
        this.sc=new Scanner(System.in);
    }

    public void run() {

        if(str.equalsIgnoreCase("l")){
            liaotian();
        }if(str.equalsIgnoreCase("w")){
            wenjian();
        }
    }
    public void wenjian(){
        System.out.println("=======进入文件传输=======");
        String s= sc.next();
        try {
            dos.writeUTF(s);
            dos.flush();
            System.out.println("输入本地文件路径：");
            String filepath= sc.next();
            String filename=filepath.substring(filepath.lastIndexOf("\\")+1);
            dos.writeUTF(filename);
            dos.flush();
            File f= new File(filepath);
            InputStream in= new FileInputStream(f);
            byte[] b= new byte[1024];
            int i=0;
            while((i=in.read(b))!=-1){
                dos.write(b, 0, i);

            }
            dos.flush();
            in.close();
            System.out.println("对"+s+"文件传输完成");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void liaotian (){
        System.out.println("=======进入聊天=======");

        String info;
        try {
            while (true) {
                info = sc.next();//4
                if (info.equals("bye")) {
                    System.out.println("结束与对方聊天!");
                    break;
                }

                dos.writeUTF(info);
                dos.flush();
                info = sc.next();///5
                dos.writeUTF(info);
                dos.flush();
                if (info.equals("bye")) {
                    System.out.println("结束与对方聊天!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
