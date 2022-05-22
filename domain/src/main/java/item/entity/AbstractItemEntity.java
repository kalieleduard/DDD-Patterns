package item.entity;

import lombok.Getter;
import lombok.Setter;
import root.AggregateRoot;
import validation.ValidationHandler;

@Getter
@Setter
public abstract class AbstractItemEntity extends AggregateRoot<ItemID> implements Cloneable {
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

    public AbstractItemEntity update(
            final String aName,
            final double aPrice,
            final int anAmount,
            final ItemCategoryEnum aCategory
    ) {
        this.itemName = aName;
        this.itemPrice = aPrice;
        this.amount = anAmount;
        this.itemCategory = aCategory;
        return this;
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new ItemValidator(this, handler).validate();
    }

    public abstract double calculateTaxes();

    @Override
    public AbstractItemEntity clone() {
        try {
            return (AbstractItemEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
