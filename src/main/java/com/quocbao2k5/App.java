package com.quocbao2k5;

import java.util.Locale;
import java.util.Scanner;

public class App
{
    private static Company company = new Company();
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.GERMAN);

    public static void main( String[] args )
    {
        while(true) {
            run();
            System.out.print("Press enter to continue...");
            sc.nextLine();
        }
    }


    public static void run() {
        menu();
        try {
            int select = Integer.parseInt(sc.nextLine());
            selection(select);
        } catch (Exception e) {
            System.out.println("Wrong selection!");
            run();
        }
    }


    public static void menu() {
        System.out.println("******************************************");
        System.out.println("*   Key 1: Add an employee               *");
        System.out.println("*   Key 2: Print all employees           *");
        System.out.println("*   Key 3: Find an employee              *");
        System.out.println("*   Key 4: Delete an employee            *");
        System.out.println("*   Key 5: Update information            *");
        System.out.println("*   Key 6: Find employees by salary      *");
        System.out.println("*   Key 7: Sort list by name             *");
        System.out.println("*   Key 8: Sort list by salary           *");
        System.out.println("*   Key 9: Top 5 Employee                *");
        System.out.println("*   Key 0: Exit                          *");
        System.out.println("******************************************");
    }

    public static void selection(int select) {
        switch (select) {
            case 1:
                menuAddEmployee();
                try {
                    int type = sc.nextInt();
                    company.addEmployee(type);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Wrong type!");
                    selection(1);
                }
                break;
            case 2:
                if(!company.getEmployees().isEmpty()) {
                    for (Employee temp : company.getEmployees()) {
                        temp.showInfo();
                        System.out.println("**********************************");
                    }
                }
                else {
                    System.out.println("List is empty!");
                }
                break;
            case 3:
                System.out.println("Input ID employee: ");
                company.findEmployee(sc.nextLine());
                break;
            case 4:
                System.out.println("Input ID employee: ");
                company.deleteEmployee(sc.nextLine());
                break;
            case 5:
                System.out.println("Input ID employee: ");
                company.updateInfo(sc.nextLine());
                break;
            case 6:
                System.out.println("Input salary: ");
                company.filterEmployeeBySalary(sc.nextDouble());
                sc.nextLine();
                break;
            case 7:
                company.sortByName();
                break;
            case 8:
                company.sortBySalary();
                break;
            case 9:
                company.sortBySalary();
                for(int i = 0; i < 5; i++) {
                    if(i == company.getEmployees().size()) {
                        break;
                    }
                    company.getEmployees().get(i).showInfo();
                    System.out.println("**********************************");
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuAddEmployee() {
        System.out.println("******************************************");
        System.out.println("*       Select a type of employees       *");
        System.out.println("******************************************");
        System.out.println("*   Key 1: Add an employee               *");
        System.out.println("*   Key 2: Add a marketing employee      *");
        System.out.println("*   Key 3: Add an manager                *");
        System.out.println("******************************************");
    }
}