//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pjhuc01.socket02;

import com.google.gson.Gson;
import main.demo.Student;
import main.demo.test07_socket.ClientTest07;
import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class CommonSend04 {
    private static Properties innerService = new Properties();
    private static int PORT;
    private static String IP;



    public CommonSend04() {
    }

    public static Object send(Object data) {
        new HashMap();
        Socket s = null;
        try {
            s = new Socket("10.150.251.230", 15666);
//            s = new Socket("10.150.2.191", 15666);
            s.setSoTimeout(3000);
            String json = (new Gson()).toJson(data);
            byte[] bytes = json.getBytes();
            IOUtils.write(String.format("%08d", bytes.length).getBytes(), s.getOutputStream());
            IOUtils.write(bytes, s.getOutputStream());
            byte[] buffer = new byte[8];
            IOUtils.readFully(s.getInputStream(), buffer);
            int len = Integer.parseInt(new String(buffer));
            buffer = new byte[len];
            IOUtils.readFully(s.getInputStream(), buffer);
            json = new String(buffer, "utf-8");

            Map map2 = (Map)(new Gson()).fromJson(json, Map.class);
            Map var9 = map2;
            return var9;
        } catch (Exception var12) {
            var12.printStackTrace();

        } finally {
            IOUtils.closeQuietly(s);
        }
        return new HashMap();
    }

    public static void main(String[] args) {
        try {
            Socket s = new Socket("10.150.251.230", 15666);
            //启动一个线程  用来等待接收服务端的信息
            ClientTest07.ServerThread st = new ClientTest07().new ServerThread(s);
            st.start();
            //
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                dos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
