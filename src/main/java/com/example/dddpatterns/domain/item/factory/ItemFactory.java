package com.example.dddpatterns.domain.item.factory;

import com.example.dddpatterns.domain.item.entity.*;

import java.util.Objects;

public class ItemFactory {
    private static AbstractItemEntity itemEntity;

    public static AbstractItemEntity makeItemByType(ItemCategoryEnum itemCategory) {
        switch (itemCategory) {
            case ELECTRONIC:
                itemEntity = new ElectronicItemEntity();
                break;
            case DRINK:
                itemEntity = new DrinkItemEntity();
                break;
            case FOOD:
                itemEntity = new FoodItemEntity();
                break;
        }

        return Objects.requireNonNull(itemEntity);
    }
}
