package item.entity;

public class FoodItemEntity extends AbstractItemEntity {
    public FoodItemEntity(
            ItemID itemID,
            String itemName,
            double itemPrice,
            int amount,
            ItemCategoryEnum categoryEnum
    ) {
        super(itemID, itemName, itemPrice, amount, categoryEnum);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.FOOD.getItemTax() * this.itemPrice);
    }
}
