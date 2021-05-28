package main.pjhuc01.test06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8000);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("nihao");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
