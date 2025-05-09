package com.genspark.appManagementSystem.enums;

public  enum AllowedCategory {
    Games,
    Utility,
    Finance,
    Enterprise;

    public static boolean isValid(String category) {
        for (AllowedCategory cat : values()) {
            if (cat.name().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}