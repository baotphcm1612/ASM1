package com.quocbao2k5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }
    
    public void clearList() {
        if(employees != null && !employees.isEmpty())
            this.employees.clear();
    }
    
    public void addEmployee(int type) {
        switch (type) {
            case 1:
                System.out.println("Add employee");
                employees.add(new Employee().setInfo());
                break;
            case 2:
                System.out.println("Add marketing employee");
                employees.add(new Marketing().setInfo());
                break;
            case 3:
                System.out.println("Add manager");
                employees.add(new Manager().setInfo());
                break;
            default:
                break;
        }
    }

    public Employee findEmployee(String id) {
        if(employees != null && !employees.isEmpty()) {
            for(Employee temp : employees) {
                if(temp.getId().equals(id)) {
                    return temp;
                }
            }
        }
        return null;
    }

    public void filterEmployeeBySalary(double salary) {
        if(employees != null && !employees.isEmpty()) {
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
        else {
            System.out.println("List is empty!");
        }
    }

    public void sortByName() {
        if(employees != null && !employees.isEmpty()) {
            Collections.sort(employees,Comparator.comparing(Employee::getName));
            System.out.println("Done!");
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public void sortBySalary() {
        if(employees != null && !employees.isEmpty()) {
            Collections.sort(employees,Comparator.comparing(Employee::getSalary).reversed());
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public void deleteEmployee(String id) {
        if(employees != null && !employees.isEmpty()) {
            if(employees.removeIf(temp -> temp.getId().equals(id))) {
                System.out.println("Delete success!");
            }
            else {
                System.out.println("Employee not found!");
            }
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public void updateInfo(String id) {
        Employee temp = findEmployee(id);
        temp.updateInfo();
    }
}
