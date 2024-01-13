package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Manager extends Employee {
    private double resMoney;

    public Manager() {

    }

    public Manager(String id, String name, double salary, double resMoney) {
        super(id, name, salary);
        this.resMoney = resMoney;
    }

    public void setResMoney(double resMoney) {
        this.resMoney = resMoney;
    }

    public double getResMoney() {
        return this.resMoney;
    }

    @Override
    public double getIncomeMoney() {
        return this.getSalary() + resMoney;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("ResMoney: " + format.format(resMoney));
    }

    @Override
    public Employee setInfo() {
        super.setInfo();
        System.out.print("Input ResMoney: ");
        this.setResMoney(sc.nextDouble());
        sc.nextLine();
        return this;
    }

    @Override
    public void updateInfo() {
        try {
            super.updateInfo();
            String ResMoney = null;
            System.out.print("Input ResMoney: ");
            ResMoney = sc.nextLine();
            if(!ResMoney.isBlank()) {
                this.resMoney = Double.parseDouble(ResMoney);
            }
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }
    }
}
