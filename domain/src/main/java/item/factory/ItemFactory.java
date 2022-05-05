package item.factory;

import item.exception.ItemNotFoundException;
import item.entity.*;

public class ItemFactory {
    public static AbstractItemEntity makeItemByType(ItemCategoryEnum itemCategory) {
        switch (itemCategory) {
            case ELECTRONIC:
                return new ElectronicItemEntity();
            case DRINK:
                return new DrinkItemEntity();
            case FOOD:
                return new FoodItemEntity();
        }
        throw new ItemNotFoundException();
    }
}
