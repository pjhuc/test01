package main.demo.test07_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest07 {

    //监听到多个客户端
    static List clients = new ArrayList();
    public static void main(String[] args) {
        boolean flag = true;
        try {
            ServerSocket ss = new ServerSocket(8000);
            while(flag){
                Socket s = ss.accept();
                //监听到一个  客户端socket  然后把socket封装到线程对象中
                ClientThread ct = new ServerTest07().new ClientThread(s);
                clients.add(ct);
                ct.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 成员内部类  线程类  这个线程类的对象  就是一个客户端
     */
    public class ClientThread extends Thread {
        Socket s;
        DataInputStream dis;
        DataOutputStream dos;
        public ClientThread(Socket s){
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while(true){
                    // 得到当前客户端给我发送的信息
                    String msg = dis.readUTF();
                        //发送给所有人
                        for(int i = 0;i < clients.size();i++) {
                            ClientThread ct = (ClientThread)clients.get(i);
                            ct.dos.writeUTF(msg);
                            ct.dos.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
