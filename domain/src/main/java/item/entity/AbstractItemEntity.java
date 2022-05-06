package item.entity;

import lombok.*;
import root.AggregateRoot;

@Getter
@Setter
public abstract class AbstractItemEntity extends AggregateRoot<ItemID> {
    protected String itemName;
    protected double itemPrice;
    protected int amount;

    public AbstractItemEntity(ItemID itemID, String itemName, double itemPrice, int amount) {
        super(itemID);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
    }

    public AbstractItemEntity(ItemID itemID) {
        super(itemID);
    }

    public abstract double calculateTaxes();
}
