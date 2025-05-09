package com.genspark.appManagementSystem;

import com.genspark.appManagementSystem.exception.AppSizeTooLargeException;
import com.genspark.appManagementSystem.exception.DeveloperBannedException;
import com.genspark.appManagementSystem.exception.InvalidCategoryException;
import com.genspark.appManagementSystem.exception.PricingException;

import java.util.Arrays;
import java.util.List;

public class AppManagementSystem {

    public static void main(String[] args) {
        List<App> submissions = Arrays.asList(
                new App("FunGame", "Alice", 450.0, "Games", 20.0),
                new App("HackTool", "HackerPro", 300.0, "Utility", 10.0),
                new App("MegaCalc", "Bob", 550.0, "Finance", 0.0),
                new App("EnterpriseSuite", "Charlie", 200.0, "Enterprise", 150.0),
                new App("FinanceX", "Dana", 120.0, "Finance", -5.0),
                new App("CoolApp", "Eve", 400.0, "Social", 30.0)
        );



     for (App app : submissions) {
        try {
            AppValidator.validate(app);
            System.out.println("App " + app.appName + " by " + app.developerName + " is approved for publishing.");
        } catch (AppSizeTooLargeException | InvalidCategoryException |
                 PricingException | DeveloperBannedException exception) {
            System.out.println("Validation failed for " + app.appName + ": " + exception.getMessage());
        } finally {
            System.out.println("Validation completed for " + app.appName);
        }
    }
}
}