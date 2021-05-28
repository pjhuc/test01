package main.pjhuc01.test16_reflex.dao;

import main.pjhuc01.test16_reflex.bean.Emp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UserDao extends BaseDao{

    public Emp getEmp(int empno) {
        /*String sql = "select * from emp";
        JdbcTemplate jt = new JdbcTemplate();
        ResultSet rs = jt.query(sql);
        Emp emp = null;
        try {
            if(rs.next()) {
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jt.closeRes();
        }*/
        Object obj = this.get(Emp.class, empno);
        return (Emp) obj;
    }

    public void getEmpInfo() {
        List<Emp> empList = null;
        try {
            empList = this.getObjects(Emp.class);
            for (int i = 0; i < empList.size() ; i++) {
                    System.out.println(empList.get(i).getEmpno()+"---"+empList.get(i).getEname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveEmp(Emp emp) {
        try {
            this.save(emp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDao ud = new UserDao();
//        Emp emp = new Emp(7777,"xiaoxiao","hehhe",7);
        Emp emp = new Emp();
        emp.setEmpno(1234);
        emp.setEname("sf");
        emp.setJob("mgr");
        emp.setMgr(7);
        ud.saveEmp(emp);
//        System.out.println(emp.getEmpno()+"----"+ emp.getEname() +"-----"+emp.getMgr());
//        ud.getEmpInfo();
    }

}
