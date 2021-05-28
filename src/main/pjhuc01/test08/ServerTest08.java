package main.pjhuc01.test08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest08 {
    static List clients = new ArrayList();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            while(true){
                Socket s = ss.accept();
                System.out.println("客户端连接。。。。");
                // 匿名内部类  线程类  客户端对象
                ServerTest08.ClientThread c = new ClientThread(s);
                //把客户端线程存储在一个容器中
                clients.add(c);
                //启动客户端线程
                c.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientThread extends Thread{
        Socket s;
        DataOutputStream dos;
        DataInputStream dis;
        public ClientThread(Socket s){
            this.s = s;
            try {
                dos = new DataOutputStream(s.getOutputStream());
                dis = new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            // 循环  用来等待客户端发送信息
            while(true) {
                try {
                    String msg = dis.readUTF();
                    //把得到的字符串分发到各个客户端中
                    for (int i = 0; i < clients.size(); i++) {
                        ClientThread t = (ClientThread) clients.get(i);
                        if(t.getName().equals(this.getName())){

                        }else{
                            t.dos.writeUTF(msg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
