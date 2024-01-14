package com.quocbao2k5;

import java.text.NumberFormat;
import java.util.Locale;

public class Marketing extends Employee {
    private double bonus;
    private double commission;

    public Marketing() {

    }

    public Marketing(String id, String name, double salary, double bonus, double comission) {
        super(id, name, salary);
        this.bonus = bonus;
        this.commission = comission;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getBonus() {
        return this.bonus;
    }

    public double getCommission() {
        return this.commission;
    }

    @Override
    public double calcIncomeMoney() {
        return this.getSalary() + this.getBonus() + this.getCommission();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Bonus: " + format.format(this.getBonus()));
        System.out.println("Commission: " + format.format(this.getCommission()));
    }

    @Override
    public Employee setInfo() {
        try {
            super.setInfo();
            System.out.print("Input Bonus: ");
            this.setBonus(Double.parseDouble(sc.nextLine()));
            System.out.print("Input comission: ");
            this.setCommission(Double.parseDouble(sc.nextLine()));
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
            System.out.print("Input commission: ");
            comission = sc.nextLine();
            if(!bonus.isBlank()) {
                this.setBonus(Double.parseDouble(bonus));
            }
            if(!comission.isBlank()) {
                this.setCommission(Double.parseDouble(comission));
            }
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }

    }
}
