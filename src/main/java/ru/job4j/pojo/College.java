package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Исманский Альберт Анатольевич");
        student.setGroup(28473);
        student.setCreated(new Date());
        System.out.println("Студент " + student.getFullName() + " группа №"
                + student.getGroup() + " дата поступления: " + student.getCreated());
    }
}
