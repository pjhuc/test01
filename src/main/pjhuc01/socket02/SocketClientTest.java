package main.pjhuc01.socket02;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class SocketClientTest {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 5209;

    private static void test() {
        Socket socket = null;
        DataInputStream dis = null;
        InputStream is = null;

        try {
            socket = new Socket(HOST, PORT);
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            while (true) {
                System.out.println("receive_msg:" + dis.readUTF());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        test();
    }
}
