package com.example.demo.util;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;

import java.time.LocalDate;

public final class ModelValidator {

    private ModelValidator() {
        // utility class – prevent instantiation
    }

    /* ================= USER VALIDATION ================= */

    public static void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (isBlank(user.getEmail())) {
            throw new IllegalArgumentException("Email is required");
        }
        if (isBlank(user.getPassword())) {
            throw new IllegalArgumentException("Password is required");
        }
        if (isBlank(user.getRole())) {
            throw new IllegalArgumentException("Role is required");
        }
    }

    /* ================= PRODUCT VALIDATION ================= */

    public static void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (isBlank(product.getModelNumber())) {
            throw new IllegalArgumentException("Model number required");
        }
        if (isBlank(product.getCategory())) {
            throw new IllegalArgumentException("Category required");
        }
    }

    /* ================= WARRANTY VALIDATION ================= */

    public static void validateWarranty(Warranty warranty) {
        if (warranty == null) {
            throw new IllegalArgumentException("Warranty cannot be null");
        }

        LocalDate purchase = warranty.getPurchaseDate();
        LocalDate expiry = warranty.getExpiryDate();

        if (purchase == null || expiry == null) {
            throw new IllegalArgumentException("Purchase and expiry dates are required");
        }

        if (!expiry.isAfter(purchase)) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }

        if (isBlank(warranty.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number required");
        }
    }

    /* ================= HELPER ================= */

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
