package com.genspark.appManagementSystem;
import com.genspark.appManagementSystem.exception.AppSizeTooLargeException;
import com.genspark.appManagementSystem.exception.DeveloperBannedException;
import com.genspark.appManagementSystem.exception.InvalidCategoryException;
import com.genspark.appManagementSystem.exception.PricingException;
import com.genspark.appManagementSystem.enums.AllowedCategory;
import com.genspark.appManagementSystem.enums.BannedDeveloper;

class AppValidator {

        public static void validate(App app) throws AppSizeTooLargeException, InvalidCategoryException,
                PricingException, DeveloperBannedException {

            if (app.appSizeInMB > 500) {
                throw new AppSizeTooLargeException("App size exceeds the 500MB limit.");
            }

            if (!AllowedCategory.isValid(app.category)) {
                throw new InvalidCategoryException("Invalid category: " + app.category);
            }

            if (app.price < 0 || (app.price > 100 && !app.category.equalsIgnoreCase("Enterprise"))) {
                throw new PricingException("Invalid pricing for app: " + app.price);
            }

            if (BannedDeveloper.isBanned(app.developerName)) {
                throw new DeveloperBannedException("Developer is banned: " + app.developerName);
            }
        }
    }
