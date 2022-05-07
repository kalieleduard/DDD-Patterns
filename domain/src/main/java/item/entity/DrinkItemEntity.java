package item.entity;

public class DrinkItemEntity extends AbstractItemEntity {
    public DrinkItemEntity(
            ItemID itemID,
            String itemName,
            double itemPrice,
            int amount,
            ItemCategoryEnum categoryEnum) {
        super(itemID, itemName, itemPrice, amount, categoryEnum);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.DRINK.getItemTax() * this.itemPrice);
    }
}
