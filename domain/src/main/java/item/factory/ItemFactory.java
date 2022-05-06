package item.factory;

import item.entity.*;

public class ItemFactory {
    public static AbstractItemEntity makeItemByType(ItemCategoryEnum itemCategory) {
        switch (itemCategory) {
            case ELECTRONIC:
                return new ElectronicItemEntity(ItemID.unique());
            case DRINK:
                return new DrinkItemEntity(ItemID.unique());
            case FOOD:
                return new FoodItemEntity(ItemID.unique());
        }
        throw new IllegalArgumentException();
    }
}
