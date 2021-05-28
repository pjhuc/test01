package main.pjhuc01.test18_reflect.test;

public class Student {

    private int sutId;
    private String sutName;
    public String sutAge;
    String address;
    protected String sex;

    public int getSutId() {
        return sutId;
    }

    public void setSutId(int sutId) {
        this.sutId = sutId;
    }

    public String getSutName() {
        return sutName;
    }

    public void setSutName(String sutName) {
        this.sutName = sutName;
    }

    public String getSutAge() {
        return sutAge;
    }

    public void setSutAge(String sutAge) {
        this.sutAge = sutAge;
    }

    private void showPrivateMethed(){
        System.out.println("showPrivateMethed()");
    }

    void showDefault(){
        System.out.println("showDefault()");
    }

    protected void showProtectedMethed(){
        System.out.println("showProtectedMethed()");
    }

    public Student(int sutId, String sutName, String sutAge, String address, String sex) {
        this.sutId = sutId;
        this.sutName = sutName;
        this.sutAge = sutAge;
        this.address = address;
        this.sex = sex;
    }

    public Student() {
    }
}
