package main.pjhuc01.test08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest08 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8000);
            ServerThread st = new ServerThread(s);
            st.start();
            //
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            System.out.println("请输入信息：");
            dos.writeUTF(sc.next());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收来自服务端的信息
    public static class ServerThread extends Thread{
        Socket s ;
        DataInputStream dis;
        public ServerThread(Socket s){
            this.s = s;
            try {
                dis =  new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run(){
            while(true){
                try {
                    while(true){
                        String ms = dis.readUTF();
                        System.out.println("server:"+ms);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
