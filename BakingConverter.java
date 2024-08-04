package com.example.termproject.Model;

import java.util.HashMap;
import java.util.Map;

public class BakingConverter {
    private double value;
    private String fromUnit;
    private String toUnit;

    private static final Map<String, Double> CONVERSIONS = new HashMap<>();
    static {
        // Base unit is cups
        CONVERSIONS.put("cup", 1.0);
        CONVERSIONS.put("tsp", 48.0);
        CONVERSIONS.put("tbsp", 16.0);
        CONVERSIONS.put("fl_oz", 8.0);
        CONVERSIONS.put("ml", 236.588);
        CONVERSIONS.put("gram", 236.588); // Assuming water density
        CONVERSIONS.put("oz", 8.0);
    }

    public BakingConverter(double value, String fromUnit, String toUnit) {
        this.value = value;
        this.fromUnit = fromUnit.toLowerCase();
        this.toUnit = toUnit.toLowerCase();
    }

    public double convert() {
        if (fromUnit.equals(toUnit)) {
            return value;
        }

        double cupValue = toCups(value, fromUnit);
        return fromCups(cupValue, toUnit);
    }

    private double toCups(double value, String unit) {
        return value / CONVERSIONS.getOrDefault(unit, 1.0);
    }

    private double fromCups(double cups, String unit) {
        return cups * CONVERSIONS.getOrDefault(unit, 1.0);
    }

    // Getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }
}