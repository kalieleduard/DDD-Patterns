package com.example.dddpatterns.domain.item.entity;

public class ElectronicItemEntity extends AbstractItemEntity {
    public ElectronicItemEntity() { }

    public ElectronicItemEntity(String itemName, double itemPrice, int amount) {
        super(itemName, itemPrice, amount);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.ELECTRONIC.getItemTax() * this.itemPrice);
    }
}
