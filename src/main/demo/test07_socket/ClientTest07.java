package main.demo.test07_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest07 {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8000);
            //启动一个线程  用来等待接收服务端的信息
            ServerThread st = new ClientTest07().new ServerThread(s);
            st.start();
            //
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("请发送信息！");
            while (true) {
                String msg = sc.next();
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ServerThread extends Thread {
        Socket s;
        DataInputStream dis;

        public ServerThread(Socket s) {
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (true) {
                try {
                    String msg = dis.readUTF();
                    System.out.println("server:" + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
