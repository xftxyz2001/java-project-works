package com.xftxyz.chapter10;

public class T9 {

    public static void main(String[] args) {

        Course course = new Course("Java");
        course.addStudent("Peter Jones");
        course.addStudent("Kim Smith");
        course.addStudent("Anne Kennedy");

        course.dropStudent("Peter Jones");

        for (String student : course.getStudents()) {
            System.out.println(student);
        }
    }
}

class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents == students.length) {
            String[] newStudents = new String[students.length * 2];
            System.arraycopy(students, 0, newStudents, 0, students.length);
            students = newStudents;
        }
        students[numberOfStudents++] = student;
    }

    public String[] getStudents() {
        String[] result = new String[numberOfStudents];
        System.arraycopy(students, 0, result, 0, numberOfStudents);
        return result;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < numberOfStudents - 1; i++) {
                students[i] = students[i + 1];
            }
            numberOfStudents--;
        }
    }

    public void clear() {
        students = new String[100];
        numberOfStudents = 0;
    }
}