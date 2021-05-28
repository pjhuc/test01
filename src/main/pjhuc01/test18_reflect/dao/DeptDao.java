package main.pjhuc01.test18_reflect.dao;

import main.pjhuc01.test18_reflect.bean.Dept;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DeptDao extends BaseDao{

    public Dept getDept(int deptno) {
        Object obj = this.get(Dept.class, deptno);
        return (Dept) obj;

    }

    public void getDeptInfo(){
        List<Dept> deptList = this.getObjects(Dept.class);
        for (int i = 0; i < deptList.size(); i++) {
            Dept dept = deptList.get(i);
            System.out.println(dept.getDname()+"----"+dept.getDeptno()+"-----"+dept.getLoc());
        }
    }

    public void saveDept(Dept dept) {
        try {
            this.save(dept);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeptDao ud = new DeptDao();
/*        System.out.println(ud.getEmp().getEmpno());
        System.out.println(ud.getEmp().getEname());
        System.out.println(ud.getEmp().getJob());
        System.out.println(ud.getEmp().getMgr());*/

//        Dept dept = ud.getDept(10);
//        System.out.println(dept.getDeptno()+"-------"+dept.getDname()+"-----------"+dept.getLoc());

//        ud.getDeptInfo();
        Dept dept = new Dept();
        dept.setDeptno(90);
        dept.setDname("aaa");
        dept.setLoc("bbb");
        ud.saveDept(dept);
    }

}
