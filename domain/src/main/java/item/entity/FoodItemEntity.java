package item.entity;

public class FoodItemEntity extends AbstractItemEntity {
    public FoodItemEntity(ItemID itemID, String itemName, double itemPrice, int amount) {
        super(itemID, itemName, itemPrice, amount);
    }

    public FoodItemEntity(ItemID itemID) {
        super(itemID);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.FOOD.getItemTax() * this.itemPrice);
    }
}
