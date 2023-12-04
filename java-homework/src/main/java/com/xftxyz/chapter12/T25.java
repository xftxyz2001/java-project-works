package com.xftxyz.chapter12;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T25 {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            URLConnection connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                String firstName = scanner.next();
                String lastName = scanner.next();
                String rank = scanner.next();
                double salary = scanner.nextDouble();
                employees.add(new Employee(firstName, lastName, rank, salary));
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 助理教授
        List<Employee> assistant = employees.stream().filter(e -> e.rank.equals("assistant")).toList();
        // 副教授
        List<Employee> associate = employees.stream().filter(e -> e.rank.equals("associate")).toList();
        // 教授
        List<Employee> full = employees.stream().filter(e -> e.rank.equals("full")).toList();

        double assistantSalary = assistant.stream().mapToDouble(e -> e.salary).sum();
        double associateSalary = associate.stream().mapToDouble(e -> e.salary).sum();
        double fullSalary = full.stream().mapToDouble(e -> e.salary).sum();

        System.out.println("助理教授的总工资: " + assistantSalary);
        System.out.println("副教授的总工资: " + associateSalary);
        System.out.println("教授的总工资: " + fullSalary);

        // 平均工资
        System.out.println("助理教授的平均工资: " + assistantSalary / assistant.size());
        System.out.println("副教授的平均工资: " + associateSalary / associate.size());
        System.out.println("教授的平均工资: " + fullSalary / full.size());

    }
}

// FirstName1 LastName1 assistant 79174.73
class Employee {
    String firstName;
    String lastName;
    String rank;
    double salary;

    public Employee(String firstName, String lastName, String rank, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.salary = salary;
    }

    public String toString() {
        return firstName + " " + lastName + " " + rank + " " + salary;
    }
}