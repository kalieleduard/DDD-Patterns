package com.example.dddpatterns.domain.item.entity;

public enum ItemCategoryEnum {
    ELECTRONIC(5),
    FOOD      (2),
    DRINK     (1);

    private final double itemTax;

    ItemCategoryEnum(int itemTax) {
        this.itemTax = itemTax;
    }

    public double getItemTax() {
        return calculateItemTaxPercentage();
    }

    private double calculateItemTaxPercentage() {
        return this.itemTax / 100;
    }
}
