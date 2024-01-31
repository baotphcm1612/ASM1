package com.quocbao2k5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    public static List<Employee> employees = new ArrayList<>();

    private static final int EMPLOYEE = 1;
    private static final int MARKETING = 2;
    private static final int MANAGER = 3;
    
    public static void addEmployee(int type) {
        switch (type) {
            case EMPLOYEE:
                System.out.println("Add employee");
                Employee employee = new Employee().inputInfo();
                if(employees.add(employee)) {
                    System.out.println("Done!");
                }
                else {
                    System.out.println("Add employee failed!");
                }
                break;
            case MARKETING:
                System.out.println("Add marketing employee");
                Employee marketing = new Marketing().inputInfo();
                if(employees.add(marketing)) {
                    System.out.println("Done!");
                }
                else {
                    System.out.println("Add marketing failed!");
                }
                break;
            case MANAGER:
                System.out.println("Add manager");
                Employee manager = new Manager().inputInfo();
                if(employees.add(manager)) {
                    System.out.println("Done!");
                }
                else {
                    System.out.println("Add manager failed!");
                }
                break;
            default:
                System.out.println("Wrong type!");
                break;
        }
    }

    public static Employee findEmployee(String id) {
        if(!employees.isEmpty()) {
            for(Employee temp : employees) {
                if(temp.getId().equals(id)) {
                    return temp;
                }
            }
        }
        return null;
    }

    public static void filterEmployeeBySalary(double salary) {
        if(!employees.isEmpty()) {
            boolean isFound = false;
            for(Employee temp : employees) {
                if(temp.getSalary() == salary) {
                    temp.showInfo();
                    isFound = true;
                }
            }
            if(!isFound) {
                System.out.println("Employee not found!");
            }
        }
    }

    public static void sortByName() {
        if(!employees.isEmpty()) {
            Collections.sort(employees,Comparator.comparing(Employee::getName));
            System.out.println("Done!");
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public static void sortBySalary() {
        if(!employees.isEmpty()) {
            Collections.sort(employees,Comparator.comparing(Employee::getNetSalary).reversed());
            System.out.println("Done!");
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public static void deleteEmployee(String id) {
        if(!employees.isEmpty()) {
            if(employees.removeIf(temp -> temp.getId().equals(id))) {
                System.out.println("Delete success!");
            }
            else {
                System.out.println("Employee not found!");
            }
        }
    }
 
    public static void updateInfo(String id) {
        Employee temp = findEmployee(id);
        if(temp != null)
            temp.updateInfo();
        else 
            System.out.println("Cannot found employee!");
    }

    
}
