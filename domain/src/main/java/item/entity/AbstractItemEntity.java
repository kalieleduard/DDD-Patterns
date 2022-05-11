package item.entity;

import lombok.Getter;
import lombok.Setter;
import root.AggregateRoot;
import validation.ValidationHandler;

@Getter
@Setter
public abstract class AbstractItemEntity extends AggregateRoot<ItemID> {
    protected String itemName;
    protected double itemPrice;
    protected int amount;
    protected ItemCategoryEnum itemCategory;

    public AbstractItemEntity(ItemID itemID, String itemName, double itemPrice, int amount, ItemCategoryEnum itemCategory) {
        super(itemID);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
        this.itemCategory = itemCategory;
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new ItemValidator(this, handler).validate();
    }

    public abstract double calculateTaxes();
}
