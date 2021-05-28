package main.pjhuc01.test17;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class Test17 {
    public static void main(String[] args) {

        try{
//		1.注册驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
//		2.得到链接
            String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String username = "scott";
            String password = "1";
            Connection conn = DriverManager.getConnection(url,username,password);
            //建立调用存储过程的通道
            CallableStatement patm = conn.prepareCall("{call pro_queryperson(?,?,?,?)}");
            //对in参数，赋值
            patm.setInt(1,7788);
            //对out参数，申明
            patm.registerOutParameter(2,oracle.jdbc.OracleTypes.VARCHAR);
            patm.registerOutParameter(3,oracle.jdbc.OracleTypes.NUMBER);
            patm.registerOutParameter(4,oracle.jdbc.OracleTypes.VARCHAR);
            //执行调用
            patm.execute();

            //取出结果
            String ename = patm.getString(2);
            double sal = patm.getDouble(3);
            String job = patm.getString(4);
            System.out.println(ename + "---" + sal + "---" + job);
//		关闭资源
            patm.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}