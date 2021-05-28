//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pjhuc01.socket02;

import com.google.gson.Gson;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class CommonSend {
    private static Properties innerService = new Properties();
    private static int PORT;
    private static String IP;



    public CommonSend() {
    }

    public static Object send(Map<String, String> data) {
        new HashMap();
        Socket s = null;
        try {
            s = new Socket("10.150.2.191", 10003);
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
        map.put("interface","390040");
        map.put("transaction","390040");
//        map.put("trninr","0000930");
        map.put("branch","0001");
        map.put("usr","0001");
        map.put("lmtctrid","2018102100000007");
//        map.put("wthbsn","Y");
//        Map map2 = (HashMap)send(map);
////        for(Object key : map2.entrySet()){
////            System.out.println(key);
//        }
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><transaction><header><ver>1.0</ver><msg><sndAppCd>UPP</sndAppCd><sndDt>20191113</sndDt><sndTm>093611</sndTm><seqNb>UPP11300000031951000</seqNb><msgCd>ISS.100100030.01</msgCd><callTyp>SYN</callTyp><replyToQ>REP.TCP.GWIN</replyToQ><srcAppCd>UPP</srcAppCd><srcNb>GUPP-201911130004383016</srcNb><rcvAppCd>ISS</rcvAppCd></msg></header><body><request><ReqBaseHdr><ChnlCD>0005</ChnlCD><InsNo>0001</InsNo><TlrNo>UPP9000001</TlrNo><BrNo>5129</BrNo><LglPsnID>001</LglPsnID></ReqBaseHdr><ReqBizHdr><TxCD>0000000</TxCD></ReqBizHdr><Trano>000004383015</Trano><Pdate>20191113</Pdate><MsgId>2019110400138521</MsgId><PmtKd>A113</PmtKd><DbtrAcct>313224000015000000</DbtrAcct><DbtrNm>????????</DbtrNm><DbtrIssuer>313224000015</DbtrIssuer><DbtrBrnchId>313224000015</DbtrBrnchId><DbtrMmbId>313224000015</DbtrMmbId><DbtrAddr>??????</DbtrAddr><CdtrAcct>6229820000000865862</CdtrAcct><CdtrNm>???</CdtrNm><CdtrIssuer>313124003282</CdtrIssuer><CdtrBrnchId>313124003282</CdtrBrnchId><CdtrMmbId>313138000019</CdtrMmbId><Amount>100000.00</Amount><AddtlInf>????</AddtlInf><BsDate>20191113</BsDate><FeeCode>OUR</FeeCode></request></body></transaction>";
//        map.put("str", str);
        Object obj = send(map);
        System.out.println(obj.toString());

    }
}
