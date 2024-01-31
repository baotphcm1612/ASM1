package com.quocbao2k5;

public class Optimize {
    public static String optimizeName(String name) {
        StringBuilder optimizedName = new StringBuilder();
        String[] splitName = name.trim().toLowerCase().split(" ");
        for (String temp : splitName) {
            optimizedName.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1)).append(" ");
        }
        return optimizedName.toString().trim();
    }
}
