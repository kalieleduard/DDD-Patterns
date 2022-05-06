package item.entity;

public class DrinkItemEntity extends AbstractItemEntity {
    public DrinkItemEntity(ItemID itemID, String itemName, double itemPrice, int amount) {
        super(itemID, itemName, itemPrice, amount);
    }

    public DrinkItemEntity(ItemID itemID) {
        super(itemID);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.DRINK.getItemTax() * this.itemPrice);
    }
}
