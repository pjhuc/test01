//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pjhuc01.socket02;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonSend02 {
    private static Properties innerService = new Properties();
    private static int PORT;
    private static String IP;



    public CommonSend02() {
    }

    public static Object send(Map<String, String> data) {
        new HashMap();
        Socket s = null;
        try {
            s = new Socket("10.150.2.190", 10003);
            s.setSoTimeout(100000);
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
        Map<String, String> map = new HashMap();
        map.put("interface","HX0001");
        map.put("transaction","HX0001");
//        map.put("trninr","00001349");//其中一条act为空，
        map.put("trninr","00001353");
//        map.put("trninr","00001842");
        map.put("usr","222222");
        map.put("relusr","222222");
        map.put("branch","222222");
        Object obj = send(map);
        System.out.println(obj.toString());

    }
}
