package main.pjhuc01.test16_reflex.dao;

import main.pjhuc01.test16_reflex.bean.Dept;

import java.util.List;

public class DeptDao extends BaseDao{

    public Dept getDept(int deptno) {
        Object obj = this.get(Dept.class, deptno);
        return (Dept) obj;
    }

    public void getDeptInfo() {
        List<Dept> objList = this.getObjects(Dept.class);
        for(int i = 0;i < objList.size();i++) {
            Dept dept = objList.get(i);
            System.out.println(dept.getDeptno() +"----"+ dept.getDname());
        }
    }

    public static void main(String[] args) {
        DeptDao ud = new DeptDao();
//        Dept dept = ud.getDept(10);
//        System.out.println(dept.getDeptno()+"----"+dept.getDname()+"------------"+dept.getLoc());
        ud.getDeptInfo();
    }

}
