package main.pjhuc01.socket02;


import com.google.gson.Gson;
import com.pjhuc01.socket02.CommonSend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient2 {

    public static void main(String[] args) throws Exception {

            Socket socket = null;
            ObjectOutputStream os = null;
            ObjectInputStream is = null;

            try {
                Map<String,String> map = new HashMap<String,String>();
                map.put("trninr","00000001");
                map.put("interfaceName","222");
                map.put("transaction","222");
                CommonSend.send(map);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

