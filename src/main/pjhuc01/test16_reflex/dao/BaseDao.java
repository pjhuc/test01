package main.pjhuc01.test16_reflex.dao;

import main.pjhuc01.test16_reflex.bean.Emp;
import main.pjhuc01.test16_reflex.util.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BaseDao extends JdbcTemplate {

    public Object get(Class c, int empno) {
        String clazzName = c.getName();
        System.out.println(clazzName);
        String tableName = clazzName.substring(clazzName.lastIndexOf(".") + 1);
        System.out.println(tableName);
        String sql = "select * from " + tableName + " where empno  = " + empno;
        ResultSet rs = this.query(sql);
        Object obj = null;
        try {
            if (rs.next()) {
                // 利用反射创建对象
                obj = c.newInstance();
                // 利用反射得到类中的方法
                Method[] ms = c.getMethods();
                for (int i = 0; i < ms.length; i++) {
                    Method m = ms[i];
                    if (m.getName().startsWith("set")) {
                        String filedName = m.getName().substring(3);
                        Class<?>[] paramTypes = m.getParameterTypes();
                        if (paramTypes[0] == String.class) {
                            String value = rs.getString(filedName);
                            m.invoke(obj, value);
                        } else {
                            int value = rs.getInt(filedName);
                            m.invoke(obj, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return obj;
    }

    /**
     * 通过反射 得到某种类型 多个对象
     * 类名 表名 属性和字段名
     */
    public List getObjects(Class c) {
        String className = c.getName();
        String tableName = className.substring(className.lastIndexOf(".") + 1);
        String sql = "select * from " + tableName;
        ResultSet rs = this.query(sql);
        List list = new ArrayList();
        try {
            while (rs.next()) {
                Object obj = c.newInstance();
                Method[] ms = c.getMethods();
                for (int i = 0; i < ms.length; i++) {
                    Method m = ms[i];
                    String methodName = m.getName();
                    if (methodName.startsWith("set")) {
                        String fieldName = methodName.substring(3);
                        Class<?>[] params = m.getParameterTypes();
                        if (params[0] == String.class) {
                            String value = rs.getString(fieldName);
                            m.invoke(obj, value);
                        } else {
                            int value = rs.getInt(fieldName);
                            m.invoke(obj, value);
                        }
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeRes();
        }
        return list;
    }

    /**
     * 在反射的基础上 写一个通用的新增方法
     * @param obj
     */
    public void save(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class c = obj.getClass();
        String className = c.getName();
        String tableName = className.substring(className.lastIndexOf(".") + 1);
        StringBuffer sql = new StringBuffer();
        sql.append("insert into " + tableName);
        Method[] ms = c.getMethods();
        //存所有的字段
        List fields = new ArrayList();
        // 存所有字段对应的值
        List values = new ArrayList();
        for (int i = 0; i < ms.length; i++) {
            Method m = ms[i];
            String methodName = m.getName();
            if(methodName.startsWith("get") && !"getClass".equals(methodName)) {
                String fieldName = methodName.substring(3);
                fields.add(fieldName);
                Object value = m.invoke(obj, null);
                values.add(value);
            }
        }
        //
        sql.append("(");
        for (int i = 0; i < fields.size(); i++) {
            if(i != fields.size()-1) {
                sql.append(fields.get(i)+",");
            }else {
                sql.append(fields.get(i));
            }
        }
        //
        sql.append(") values(");
        for (int i = 0; i < values.size(); i++) {
            if(i != values.size()-1) {
                sql.append("'"+values.get(i)+"',");
            }else {
                sql.append("'"+values.get(i)+"'");
            }
        }
        sql.append(" )");
        System.out.println(sql.toString());
        this.updateData(sql.toString());
        this.myCommit();
        this.closeRes();
    }

    public static void main(String[] args) {
        BaseDao bd = new BaseDao();
        bd.get(Emp.class, 1);
    }

}
