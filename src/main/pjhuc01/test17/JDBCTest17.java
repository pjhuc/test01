package main.pjhuc01.test17;

import java.util.HashMap;
import java.util.Map;

public class JDBCTest17 {


    public static void main(String[] args) {
//        String ss = "/app/weblogic/webapps/resource/data/pdf/311.pdf";
//        System.out.println(ss.lastIndexOf("/"));
//        System.out.println(ss.substring(ss.lastIndexOf("/")+1));
//        System.out.println(ss.substring(ss.lastIndexOf("/")+1, ss.length()-4));

//        String desPdfPath = "/app/weblogic/webapps/resource/data/pdf/311f0fde1e414de69fff778696ceae1d.pdf";
//        String filepath = desPdfPath.substring(0,desPdfPath.lastIndexOf("/"));
//        String filenam = desPdfPath.substring(desPdfPath.lastIndexOf("/")+1);
//        System.out.println(filepath +"----"+ filenam);
        String[] strArray = {"111","222","333"};
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("str01", strArray);
        map.put("str02", strArray);
        map.put("str03", strArray);
//        Set<String> strs = map.keySet();
//        for(String ss : strs) {
//            System.out.println(ss + "----" + map.get(ss));
//        }

//        Iterator<Map.Entry<String, String[]>> it = map.entrySet().iterator();
//        while(it.hasNext()) {
//            Map.Entry<String, String[]> nextval = it.next();
//            System.out.println(nextval.getKey() +"---"+ nextval.getValue());
//        }

//        for(Map.Entry<String, String[]> entry : map.entrySet()) {
//            System.out.println(entry.getKey() +"---"+ entry.getValue());
//        }

        for(String[] ss : map.values()) {
            System.out.println(ss);
        }

        

    }
}
