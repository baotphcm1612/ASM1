package com.quocbao2k5;

import java.util.Scanner;

public final class Optimize {

    public static final byte ADD = 0;
    public static final byte UPDATE = 1;
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String NAME = "name";

    private static Scanner sc = new Scanner(System.in);

    public static String optimizeName(String name) {
        StringBuilder optimizedName = new StringBuilder();
        String[] splitName = name.trim().toLowerCase().split(" ");
        for (String temp : splitName) {
            optimizedName.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1)).append(" ");
        }
        return optimizedName.toString().trim();
    }

    public static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    
    public static boolean isPhone(String phone) {
        String regex = "^(?:\\+\\d{1,14}|\\d{1,14})$";
        return phone.matches(regex);
    }

    public static double inputNumber(byte type, String variableName) {
        if(variableName == null) {
            variableName = "variable";
        }
        String number = null;
        while (true) {
            System.out.print("Input " + variableName + ": ");
            number= sc.nextLine();
            if(number.isBlank() && type == UPDATE) {
                return -1612;
            }
            if(isNumber(number) && Double.parseDouble(number) != -1612) {
                return Double.parseDouble(number);
            }
        }
    }

    public static String inputInfo(byte type, String infoName) {
        String info = null;
        while (true) {
            System.out.print("Input " + infoName + " : ");
            info = sc.nextLine();
            if(type == UPDATE && info.isBlank()) {
                return "";
            }
            if(infoName.equals(PHONE) && isPhone(info)) {
                return info;
            }
            if(infoName.equals(EMAIL) && isEmail(info)) {
                return info;
            }
            if(infoName.equals(NAME)) {
                return optimizeName(info);
            }
            System.out.println(infoName + " is invalid!");
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

    public static String inputID(byte type) {
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
}
