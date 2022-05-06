package item.entity;

public class ElectronicItemEntity extends AbstractItemEntity {
    public ElectronicItemEntity(ItemID itemID, String itemName, double itemPrice, int amount) {
        super(itemID, itemName, itemPrice, amount);
    }

    public ElectronicItemEntity(ItemID itemID) {
        super(itemID);
    }

    @Override
    public double calculateTaxes() {
        return this.itemPrice + (ItemCategoryEnum.ELECTRONIC.getItemTax() * this.itemPrice);
    }
}
