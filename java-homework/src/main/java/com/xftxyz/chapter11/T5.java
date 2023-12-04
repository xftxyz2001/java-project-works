package com.xftxyz.chapter11;

import java.util.ArrayList;

public class T5 {

    public static void main(String[] args) {

    }
}

class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public String[] getStudents() {
        String[] strings = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            strings[i] = students.get(i);
        }
        return strings;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        students.remove(student);
        numberOfStudents--;
    }

    public void clear() {
        students.clear();
        numberOfStudents = 0;
    }
}