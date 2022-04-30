package com.example.dddpatterns.domain.item.entity;

public class FoodItemEntity extends AbstractItemEntity {
    public FoodItemEntity() { }

    public FoodItemEntity(String itemName, double itemPrice, int amount) {
        super(itemName, itemPrice, amount);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.FOOD.getItemTax() * this.itemPrice);
    }
}
