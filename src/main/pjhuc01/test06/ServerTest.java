package main.pjhuc01.test06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("服务端已启动！");
            Socket s = ss.accept();
            System.out.println("接收到客户端请求！");
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("收到请求，请发送信息");
            dos.flush();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
