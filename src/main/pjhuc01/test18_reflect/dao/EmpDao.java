package main.pjhuc01.test18_reflect.dao;

import main.pjhuc01.test18_reflect.bean.Emp;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao extends BaseDao{

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
        }
        return emp;*/
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
        EmpDao ud = new EmpDao();
/*        System.out.println(ud.getEmp().getEmpno());
        System.out.println(ud.getEmp().getEname());
        System.out.println(ud.getEmp().getJob());
        System.out.println(ud.getEmp().getMgr());*/

//        Emp emp = ud.getEmp(7777);
//        System.out.println(emp.getMgr()+"-------"+emp.getEname());

//        ud.getEmpInfo();

        Emp emp = new Emp();
        emp.setEmpno(234);
        emp.setEname("sf");
        emp.setJob("md");
        emp.setMgr(999);
        ud.saveEmp(emp);
    }

}
