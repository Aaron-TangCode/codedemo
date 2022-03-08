package com.hailintang.demo.suanfa;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestStudentDistinct {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();;
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        student1.setAge(1);
        student1.setName("tanghailin");
        student1.setClassId(1);
        student2.setAge(1);
        student2.setName("tanghailin");
        student2.setClassId(1);
        student3.setAge(2);
        student3.setName("tang");
        student3.setClassId(2);
        student4.setAge(3);
        student4.setName("hailin");
        student4.setClassId(3);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        Set<Student> studentSet = getStudentSet(list);
        System.out.println(studentSet);
    }

    public static Set<Student> getStudentSet(List<Student> studentList){
        if(CollectionUtils.isEmpty(studentList)){
            return null;
        }
        Set<Student> studentSet = new HashSet<>();

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
            studentSet.add(studentList.get(i));
        }

        System.out.println(studentSet);

        return studentSet;
    }
}
