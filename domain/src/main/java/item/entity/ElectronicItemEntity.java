package item.entity;

public class ElectronicItemEntity extends AbstractItemEntity {
    public ElectronicItemEntity(
            ItemID itemID,
            String itemName,
            double itemPrice,
            int amount,
            ItemCategoryEnum itemCategoryEnum) {
        super(itemID, itemName, itemPrice, amount, itemCategoryEnum);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.ELECTRONIC.getItemTax() * this.itemPrice);
    }
}
