package main.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList();
        list.add(new Student("1",1,"1"));
        list.add(new Student("22",22,"22"));
        list.add(new Student("333",333,"333"));

/*        for(int i = 0;i < list.size();i++) {
            System.out.println(list.get(i).getName()+"-----"+list.get(i).getAge()+"-----"+list.get(i).getAddress());
        }*/

/*        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()) {
            Student nextStu = iterator.next();
            System.out.println(nextStu.getName()+"-----"+nextStu.getAge()+"-----"+nextStu.getAddress());
        }*/

        for(Student stu : list) {
            System.out.println(stu.getName()+"-----"+stu.getAge()+"-----"+stu.getAddress());
        }


    }

/*
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList();
        list.add(new Student("1",1,"1"));
        list.add(new Student("22",22,"22"));
        list.add(new Student("333",333,"333"));

        *//*for(int i = 0;i < list.size();i++) {
            System.out.println(list.get(i).getName() + list.get(i).getAge() + list.get(i).getAddress());
        }*//*

*//*        for(Student stu : list) {
            System.out.println(stu.getName() + stu.getAge() + stu.getAddress());
        }*//*

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student stu = it.next();
            System.out.println(stu.getAddress()+stu.getAge()+stu.getName());
        }
    }
*/
}
