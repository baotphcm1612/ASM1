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
        if(!getEmployees().isEmpty())
            this.getEmployees().clear();
    }
    
    public void addEmployee(int type) {
        switch (type) {
            case 1:
                System.out.println("Add employee");
                this.getEmployees().add(new Employee().setInfo());
                break;
            case 2:
                System.out.println("Add marketing employee");
                this.getEmployees().add(new Marketing().setInfo());
                break;
            case 3:
                System.out.println("Add manager");
                this.getEmployees().add(new Manager().setInfo());
                break;
            default:
                System.out.println("Wrong type!");
                break;
        }
    }

    public Employee findEmployee(String id) {
        
        if(!this.getEmployees().isEmpty()) {
            for(Employee temp : this.getEmployees()) {
                if(temp.getId().equals(id)) {
                    return temp;
                }
            }
        }
        return null;
    }

    public void filterEmployeeBySalary(double salary) {
        if(!this.getEmployees().isEmpty()) {
            boolean isFound = false;
            for(Employee temp : this.getEmployees()) {
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
        if(!this.getEmployees().isEmpty()) {
            Collections.sort(employees,Comparator.comparing(Employee::getName));
            System.out.println("Done!");
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public void sortBySalary() {
        if(!this.getEmployees().isEmpty()) {
            Collections.sort(this.getEmployees(),Comparator.comparing(Employee::getNetSalary).reversed());
            System.out.println("Done!");
        }
        else {
            System.out.println("List is empty!");
        }
    }

    public void deleteEmployee(String id) {
        if(!this.getEmployees().isEmpty()) {
            if(this.getEmployees().removeIf(temp -> temp.getId().equals(id))) {
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
        if(temp != null)
            temp.updateInfo();
        else 
            System.out.println("Cannot found employee!");
    }
}
