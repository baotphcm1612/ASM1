package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Manager extends Employee {
    private double resMoney;

    public void setResMoney(double resMoney) {
        if(resMoney != -1612)
            this.resMoney = resMoney;
    }

    public double getResMoney() {
        return this.resMoney;
    }

    @Override
    protected double calcIncomeMoney() {
        return this.getSalary() + this.getResMoney();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("ResMoney: " + format.format(this.getResMoney()));
    }

    @Override
    public void inputInfo() {
        try {
            super.inputInfo();
            this.setResMoney(Optimize.inputNumber(Optimize.ADD, "ResMoney"));
        } catch (Exception e) {
            System.out.println("Set information failed!");
        }
    }

    @Override
    public void updateInfo() {
        try {
            super.updateInfo();
            this.setResMoney(Optimize.inputNumber(Optimize.UPDATE, "ResMoney"));
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }
    }
}
