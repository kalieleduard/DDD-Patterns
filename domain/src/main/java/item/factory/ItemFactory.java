package item.factory;

import item.entity.*;

public class ItemFactory {
    public static AbstractItemEntity createItem(
            final String aName,
            final double aPrice,
            final int anAmount,
            final ItemCategoryEnum anItemCategory
    ) {
        switch (anItemCategory) {
            case ELECTRONIC:
                return new ElectronicItemEntity(ItemID.unique(), aName, aPrice, anAmount, anItemCategory);
            case DRINK:
                return new DrinkItemEntity(ItemID.unique(), aName, aPrice, anAmount, anItemCategory);
            case FOOD:
                return new FoodItemEntity(ItemID.unique(), aName, aPrice, anAmount, anItemCategory);
        }
        throw new IllegalArgumentException();
    }
}
