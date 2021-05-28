package main.pjhuc01.test16_reflex.bean;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Emp(int empno, String ename, String job, int mgr) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
    }

    public Emp(){
        super();
    }

}
