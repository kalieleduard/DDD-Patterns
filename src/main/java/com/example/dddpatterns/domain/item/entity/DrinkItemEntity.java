package com.example.dddpatterns.domain.item.entity;

public class DrinkItemEntity extends AbstractItemEntity {
    public DrinkItemEntity() { }

    public DrinkItemEntity(String itemName, double itemPrice, int amount) {
        super(itemName, itemPrice, amount);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.DRINK.getItemTax() * this.itemPrice);
    }
}
