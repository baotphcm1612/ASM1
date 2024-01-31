package com.quocbao2k5;
import java.util.Locale;
import java.util.Scanner;

public class App
{
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.GERMAN);

    private static final int ADD_EMPLOYEE = 1;
    private static final int PRINT_ALL_EMPLOYEE = 2;
    private static final int FIND_AN_EMPLOYEE = 3;
    private static final int DELETE_AN_EMPLOYEE = 4;
    private static final int UPDATE_INFORMATION = 5;
    private static final int FIND_EMPLOYEE_SALARY = 6;
    private static final int SORT_BY_NAME = 7;
    private static final int SORT_BY_SALARY = 8;
    private static final int TOP_5_EMPLOYEE = 9;

    public static void main( String[] args )
    {
        while(true) {
            run();
            System.out.print("Press enter to continue...");
            sc.nextLine();
            clearScreen();
        }
    }


    public static void run() {
        menu();
        try {
            int select = Integer.parseInt(sc.nextLine());
            selection(select);
        } catch (NumberFormatException e) {
            clearScreen();
            System.out.println("Wrong selection!!");
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
        System.out.println("*   Key 9: Top 5 Employees               *");
        System.out.println("*   Key 0: Exit                          *");
        System.out.println("******************************************");
        System.out.print("*   Input key: ");
    }

    public static void selection(int select) {
        switch (select) {
            case ADD_EMPLOYEE:
                menuAddEmployee();
                try {
                    System.out.print("*   Input key: ");
                    int type = Integer.parseInt(sc.nextLine());
                    Company.addEmployee(type);
                } catch (Exception e) {
                    System.out.println("Wrong type!");
                }
                break;
            case PRINT_ALL_EMPLOYEE:
                if(!Company.employees.isEmpty()) {
                    for (Employee temp : Company.employees) {
                        temp.showInfo();
                        System.out.println("**********************************");
                    }
                }
                else {
                    System.out.println("List is empty!");
                }
                break;
            case FIND_AN_EMPLOYEE:
                if(!Company.employees.isEmpty()) {
                    System.out.print("Input ID employee: ");
                    Employee temp = Company.findEmployee(sc.nextLine());
                    if(temp != null) {
                        temp.showInfo();
                    }
                    else {
                        System.out.println("Cannot found this employee!");
                    }
                }
                else{
                    System.out.println("List is empty!");
                }
                break;
            case DELETE_AN_EMPLOYEE:
                if(!Company.employees.isEmpty()) {
                    System.out.print("Input ID employee: ");
                    Company.deleteEmployee(sc.nextLine());
                }
                else {
                    System.out.println("List is empty!");
                }
                break;
            case UPDATE_INFORMATION:
                if(!Company.employees.isEmpty()) {
                    System.out.print("Input ID employee: ");
                    Company.updateInfo(sc.nextLine());
                }
                else {
                    System.out.println("List is empty!");
                }
                break;
            case FIND_EMPLOYEE_SALARY:
                if(!Company.employees.isEmpty()) {
                    System.out.print("Input salary: ");
                    Company.filterEmployeeBySalary(Double.parseDouble(sc.nextLine()));
                }
                else {
                    System.out.println("List is empty!");
                }
                break;
            case SORT_BY_NAME:
                Company.sortByName();
                break;
            case SORT_BY_SALARY:
                Company.sortBySalary();
                break;
            case TOP_5_EMPLOYEE:
                Company.sortBySalary();
                for(int i = 0; i < 5; i++) {
                    if(i == Company.employees.size()) {
                        break;
                    }
                    Company.employees.get(i).showInfo();
                    System.out.println("**********************************");
                }
                break;
            // Exit
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
        System.out.println("*   Key 3: Add a manager                 *");
        System.out.println("******************************************");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
