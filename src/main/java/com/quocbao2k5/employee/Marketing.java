package com.quocbao2k5.employee;

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
        return bonus;
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public double getIncomeMoney() {
        return this.getSalary() + bonus + commission;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
        System.out.println("Bonus: " + format.format(bonus));
        System.out.println("Commission: " + format.format(commission));
    }

    @Override
    public Employee setInfo() {
        super.setInfo();
        System.out.print("Input Bonus: ");
        this.setBonus(sc.nextDouble());
        System.out.print("Input comission: ");
        this.setCommission(sc.nextDouble());
        sc.nextLine();
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
                this.bonus = Double.parseDouble(bonus);
            }
            if(!comission.isBlank()) {
                this.commission = Double.parseDouble(comission);
            }
        } catch (Exception e) {
            System.out.println("Update information failure!");
        }

    }
}
