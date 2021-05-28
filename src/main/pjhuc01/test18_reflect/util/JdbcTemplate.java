package main.pjhuc01.test18_reflect.util;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * jdbc 连接数据库通用类
 */
public class JdbcTemplate {

    private static String driver;
    private static String url;
    private static String username;
    private static String passwd;

    //申明连接数据库的对象变量
    Connection conn;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;

    //注册驱动
    static {
        //加载连接数据库的配置文件
        InputStream in = JdbcTemplate.class.getClassLoader().getResourceAsStream("main/pjhuc01/test18_reflect/jdbc.propertise");
        Properties pro = new Properties();
        try {
            pro.load(in);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            passwd = pro.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    获得连接
    private void getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, passwd);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获得连接失败");
        }
    }

    //获得状态通道
    private void getStatement() {
        this.getConnection();
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取状态通道失败！");
        }
    }
    //获得预状态通道
    private void getPreStatement(String sql) {
        this.getConnection();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取预状态通道失败！");
        }
    }


    /**
     * 基于状态通道 执行批处理
     */
    public void executeBatch(List<String> sql) {
        this.getStatement();
        try {
            for (int i = 0; i < sql.size(); i++) {
                st.addBatch(sql.get(i));
            }
            st.executeBatch();
            this.myCommit();
        } catch (SQLException e) {
            e.printStackTrace();
            this.myRollBack();
        }
    }

    /**
     * 状态通道下  执行数据操作
     */
    public boolean updateData(String sql) {
        this.getStatement();
        boolean yesOrNo = false;
        try {
            int result = st.executeUpdate(sql);
            if(result > 0) {
                yesOrNo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("在状态通道下执行数据操作失败");
        }
        return yesOrNo;
    }

    /**
     * 预状态数据操作
     */
    public boolean updateData(String sql,String[] params) {
        this.getPreStatement(sql);
        boolean yesOrNo = false;
        //执行完整的sql语句
        try {
            this.bandle(params);
            int result = ps.executeUpdate();
            if(result > 0) {
                yesOrNo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("在预状态通道下执行数据操作失败");
        }
        return yesOrNo;
    }

    // 绑定参数
    private void bandle(String[] params) {
        try {
            if(params != null && params.length > 0) {
                for(int i = 0;i < params.length;i++) {
                    ps.setString(i+1,params[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询 基于状态通道
     */
    public ResultSet query(String sql) {
        this.getStatement();
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("在状态通道下执行数据查询失败");
        }
        return rs;
    }

    public ResultSet query(String sql,String[] params) {
        this.getPreStatement(sql);
        this.bandle(params);
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行预状态通道查询失败");
        }
        return rs;
    }


    public void myCommit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void myRollBack() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * @param
     */
    public void closeRes() {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(ps != null) {
                    rs.close();
                }
                if(st != null) {
                    st.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
