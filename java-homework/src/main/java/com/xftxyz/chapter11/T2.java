package com.xftxyz.chapter11;

import com.xftxyz.chapter10.t14.MyDate;

public class T2 {

    public static void main(String[] args) {

        Person person = new Person("张三", "北京", "123456789", "abc@123.com");
        Student student = new Student("李四", "上海", "987654321", "bcd@456.com", Student.SENIOR);
        Employee employee = new Employee("王五", "广州", "123456789", "def@789.ocm", "办公室", 10000, new MyDate());
        Faculty faculty = new Faculty("赵六", "深圳", "987654321", "231564897", "办公室", 20000, new MyDate(), "上午", "教授");
        Staff staff = new Staff("孙七", "天津", "123456789", "231564897", "办公室", 30000, new MyDate(), "主任");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);

    }
}

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person() {
        super();
    }

    public Person(String name, String address, String phoneNumber, String email) {
        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
                + "]";
    }

}

class Student extends Person {
    private String classStatus;

    public static final String FRESHMAN = "freshman";
    public static final String SOPHOMORE = "sophomore";
    public static final String JUNIOR = "junior";
    public static final String SENIOR = "senior";

    public Student() {
        super();
    }

    public Student(String name, String address, String phoneNumber, String email, String classStatus) {
        super(name, address, phoneNumber, email);
        this.classStatus = classStatus;
    }

    public String getClassStatus() {
        return classStatus;
    }

    @Override
    public String toString() {
        return "Student [classStatus=" + classStatus + ", toString()=" + super.toString() + "]";
    }

}

class Employee extends Person {
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee() {
        super();
    }

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary,
            MyDate dateHired) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    @Override
    public String toString() {
        return "Employee [office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + ", toString()="
                + super.toString() + "]";
    }

}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty() {
        super();
    }

    public Faculty(String name, String address, String phoneNumber, String email, String office, double salary,
            MyDate dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Faculty [officeHours=" + officeHours + ", rank=" + rank + ", toString()=" + super.toString() + "]";
    }

}

class Staff extends Employee {
    private String title;

    public Staff() {
        super();
    }

    public Staff(String name, String address, String phoneNumber, String email, String office, double salary,
            MyDate dateHired, String title) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Staff [title=" + title + ", toString()=" + super.toString() + "]";
    }

}