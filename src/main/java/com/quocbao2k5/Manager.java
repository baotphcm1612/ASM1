package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Manager extends Employee {
    private double resMoney;

    public void setResMoney(double resMoney) {
        this.resMoney = resMoney;
    }

    public double getResMoney() {
        return this.resMoney;
    }

    @Override
    public double calcIncomeMoney() {
        return this.getSalary() + resMoney;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("ResMoney: " + format.format(this.getResMoney()));
    }

    @Override
    public Employee inputInfo() {
        try {
            super.inputInfo();
            System.out.print("Input ResMoney: ");
            this.setResMoney(Double.parseDouble(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Set information failed!");
        }
        return this;
    }

    @Override
    public void updateInfo() {
        try {
            super.updateInfo();
            System.out.print("Input ResMoney: ");
            String ResMoney = sc.nextLine();
            if(!ResMoney.isBlank()) {
                this.resMoney = Double.parseDouble(ResMoney);
            }
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }
    }
}
