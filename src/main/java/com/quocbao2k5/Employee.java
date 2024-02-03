package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Employee {

    private String id;
    private String name;
    private double salary;
    private String email;
    private String phone;
    
    protected static Scanner sc = new Scanner(System.in).useLocale(Locale.GERMAN);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id){
        if(!id.isBlank())
            this.id = id;
    }

    public void setName(String name) {
        if(!name.isBlank()) {
            this.name = name;
        }
    }

    public void setSalary(double salary) {
        if(salary != -1612) {
            this.salary = salary;
        }
    }

    public void setEmail(String email) {
        if(!email.isBlank())
            this.email = email;
    }

    public void setPhone(String phone) {
        if(!phone.isBlank())
            this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    protected double calcIncomeMoney() {
        return this.getSalary();
    }

    public final double calcTax() {
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
        return this.calcIncomeMoney() - this.calcTax();
    }

    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone: " + this.getPhone());
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Salary: " + format.format(this.salary));
        System.out.println("Net salary: " + format.format(this.getNetSalary()));
    }

    public void inputInfo() {
        try {
            this.setId(Optimize.inputID(Optimize.ADD));
            this.setName(Optimize.inputInfo(Optimize.ADD, Optimize.NAME));
            this.setEmail(Optimize.inputInfo(Optimize.ADD, Optimize.EMAIL));
            this.setPhone(Optimize.inputInfo(Optimize.ADD, Optimize.PHONE));
            this.setSalary(Optimize.inputNumber(Optimize.ADD, "salary"));
        }
        catch (Exception e) {
            System.out.println("Set information failed!");
            throw e;
        }
    }

    public void updateInfo() {
        try {
            this.showInfo();
            System.out.println("------------------------");
            System.out.println("Input new information or press Enter to skip.");
            this.setId(Optimize.inputID(Optimize.UPDATE));
            this.setName(Optimize.inputInfo(Optimize.UPDATE, Optimize.NAME));
            this.setEmail(Optimize.inputInfo(Optimize.UPDATE, Optimize.EMAIL));
            this.setPhone(Optimize.inputInfo(Optimize.UPDATE, Optimize.PHONE));
            this.setSalary(Optimize.inputNumber(Optimize.UPDATE, "salary"));
        }
        catch (Exception e) {
            System.out.println("Update information failed!");
        }
    }
}