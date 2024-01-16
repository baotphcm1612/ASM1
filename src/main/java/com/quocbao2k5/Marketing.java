package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Marketing extends Employee {
    private double bonus;
    private double sales;

    public Marketing() {

    }

    public Marketing(String id, String name, double salary, double bonus, double comission) {
        super(id, name, salary);
        this.bonus = bonus;
        this.sales = comission;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getBonus() {
        return this.bonus;
    }

    public double getSales() {
        return this.sales;
    }

    @Override
    public double calcIncomeMoney() {
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
    public Employee setInfo() {
        try {
            super.setInfo();
            System.out.print("Input Bonus: ");
            this.setBonus(Double.parseDouble(sc.nextLine()));
            System.out.print("Input comission: ");
            this.setSales(Double.parseDouble(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Set information failed!");
        }
        return this;
    }

    @Override
    public void updateInfo() {
        try {
            super.updateInfo();
            String bonus = null, comission = null;
            System.out.print("Input bonus: ");
            bonus = sc.nextLine();
            System.out.print("Input sales: ");
            comission = sc.nextLine();
            if(!bonus.isBlank()) {
                this.setBonus(Double.parseDouble(bonus));
            }
            if(!comission.isBlank()) {
                this.setSales(Double.parseDouble(comission));
            }
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }

    }
}
