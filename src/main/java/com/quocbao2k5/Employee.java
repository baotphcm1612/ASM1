package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Employee {
    private String id;
    private String name;
    private double salary;
    protected static Scanner sc = new Scanner(System.in).useLocale(Locale.GERMAN);

    public Employee() {
        
    }

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calcIncomeMoney() {
        return this.getSalary();
    }

    public final double getTax() {
        if(this.calcIncomeMoney() > 15000000) {
            return 600000 + (this.calcIncomeMoney() - 15000000) * 0.12;
        }
        else if(this.calcIncomeMoney() >= 9000000) {
            return (this.calcIncomeMoney() - 9000000) * 0.1;
        }
        else {
            return 0;
        }
    }

    public final double getNetSalary() {
        return this.calcIncomeMoney() - this.getTax();
    }

    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Salary: " + format.format(this.salary));
        System.out.println("Net salary: " + format.format(this.getNetSalary()));
    }

    public Employee setInfo() {
        try {
            System.out.print("Input ID: ");
            this.setId(sc.nextLine());
            System.out.print("Input full name: ");
            this.setName(sc.nextLine());
            System.out.print("Input salary: ");
            this.setSalary(Double.parseDouble(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Set information failed!");
        }
        return this;
    }

    public void updateInfo() {
        try {
            String id = null, name = null, salary = null;
            this.showInfo();
            System.out.println("------------------------");
            System.out.println("Input new information or press Enter to skip.");
            System.out.print("Input ID: ");
            id = sc.nextLine();
            System.out.print("Input name: ");
            name = sc.nextLine();
            System.out.print("Input salary: ");
            salary = sc.nextLine();
            if(!id.isBlank()) {
                this.setId(id);
            }
            if(!name.isBlank()) {
                this.setName(name);
            }
            if(!salary.isBlank()) {
                this.setSalary(Double.parseDouble(salary));
            }
        } catch (Exception e) {
            System.out.println("Update information failed!");
        }
    }
}
