package com.quocbao2k5;

public class App
{
    public static void main( String[] args )
    {
        Employee employee = new Marketing();
        employee.setInfo();
        Employee marketing = new Marketing();
        marketing.setInfo();
        marketing.showInfo();
        Employee manager = new Manager();
        manager.setInfo();
        manager.showInfo();
        employee.updateInfo();
        employee.showInfo();
    }
}
