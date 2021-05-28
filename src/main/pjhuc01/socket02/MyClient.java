package main.pjhuc01.socket02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient {
    private final static Logger logger = Logger.getLogger(MyClient.class.getName());

    public static void main(String[] args) throws Exception {

            Socket socket = null;
            ObjectOutputStream os = null;
            ObjectInputStream is = null;

            try {
                socket = new Socket("localhost", 10003);
                os = new ObjectOutputStream(socket.getOutputStream());
                Map map = new HashMap();
                map.put("trninr","00000001");
                os.writeObject(map);
                os.flush();
            } catch(IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            } finally {
                try {
                } catch(Exception ex) {}
                try {
                } catch(Exception ex) {}
                try {
                    is.close();
                    os.close();
                    socket.close();
                } catch(Exception ex) {}
            }
        }
    }

