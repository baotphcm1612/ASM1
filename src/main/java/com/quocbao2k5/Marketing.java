package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Marketing extends Employee {
    private double bonus;
    private double sales;

    public void setBonus(double bonus) {
        if(bonus != -1612)
            this.bonus = bonus;
    }

    public void setSales(double sales) {
        if(sales != -1612)
            this.sales = sales;
    }

    public double getBonus() {
        return this.bonus;
    }

    public double getSales() {
        return this.sales;
    }

    @Override
    protected double calcIncomeMoney() {
        return this.getSalary() + this.getBonus() + this.getSales();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Bonus: " + format.format(this.getBonus()));
        System.out.println("sales: " + format.format(this.getSales()));
    }

    @Override
    public void inputInfo() {
        try {
            super.inputInfo();
            this.setBonus(Optimize.inputNumber(Optimize.ADD, "bonus"));
            this.setSales(Optimize.inputNumber(Optimize.ADD, "sales"));
        }
        catch (Exception e) {
            System.out.println("Set information failed!");
            throw e;
        }
    }

    @Override
    public void updateInfo() {
        try {
            super.updateInfo();
            this.setBonus(Optimize.inputNumber(Optimize.UPDATE, "bonus"));
            this.setSales(Optimize.inputNumber(Optimize.UPDATE, "sales"));
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }
    }
}
