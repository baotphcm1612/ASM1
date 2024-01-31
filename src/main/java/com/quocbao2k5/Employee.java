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

    private static final boolean ADD = true;
    private static final boolean UPDATE = false;
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";

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
        this.id = id;
    }

    public void setName(String name) {
        name = Optimize.optimizeName(name);
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
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
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone: " + this.getPhone());
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Salary: " + format.format(this.salary));
        System.out.println("Net salary: " + format.format(this.getNetSalary()));
    }

    public Employee inputInfo() {
        try {
            this.setId(inputID(ADD));
            this.setEmail(inputContact(ADD, EMAIL));
            this.setPhone(inputContact(ADD, PHONE));
            System.out.print("Input full name: ");
            this.setName(sc.nextLine());
            System.out.print("Input salary: ");
            this.setSalary(Double.parseDouble(sc.nextLine()));
        }
        catch (Exception e) {
            System.out.println("Set information failed!");
        }
        return this;
    }

    public void updateInfo() {
        try {
            String id = null, name = null, salary = null, email = null, phone = null;
            this.showInfo();
            System.out.println("------------------------");
            System.out.println("Input new information or press Enter to skip.");

            id = inputID(UPDATE);
            if(!id.isBlank()) {
                this.setId(id);
            }

            email = inputContact(UPDATE, EMAIL);
            if(!email.isBlank()) {
                this.setEmail(email);
            }

            phone = inputContact(UPDATE, PHONE);
            if(!phone.isBlank()) {
                this.setPhone(phone);
            }

            System.out.print("Input name: ");
            name = sc.nextLine();
            System.out.print("Input salary: ");
            salary = sc.nextLine();

            if(!name.isBlank()) {
                this.setName(name);
            }
            if(!salary.isBlank()) {
                this.setSalary(Double.parseDouble(salary));
            }
        }
        catch (Exception e) {
            System.out.println("Update information failed!");
        }
    }

    private static boolean isExist(String id) {
        if(Company.employees.isEmpty()) {
            return false;
        }
        for(var x : Company.employees) {
            if(x.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    
    private static boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    
    private static boolean isPhone(String phone) {
        String regex = "^(?:\\+\\d{1,14}|\\d{1,14})$";
        return phone.matches(regex);
    }

    private static String inputID(boolean type) {
        String id = null;
        while(true) {
            System.out.print("Input ID: ");
            id = sc.nextLine();
            if(type == UPDATE && id.isBlank()) {
                return "";
            }
            if(!isExist(id)) {
                return id;
            }
            System.out.println("ID already exists!");
        }
    }

    private static String inputContact(boolean type, String contact) {
        String info  = null;
        while (true) {
            System.out.print("Input " + contact + " : ");
            info = sc.nextLine();
            if(type == UPDATE && info.isBlank()) {
                return "";
            }
            if(contact.equals(PHONE) && isPhone(info)) {
                return info;
            }
            if(contact.equals(EMAIL) && isEmail(info)) {
                return info;
            }
            System.out.println(contact + " is invalid!");
        }
    } 
}