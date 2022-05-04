package item.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractItemEntity {
    protected String itemName;
    protected double itemPrice;
    protected int amount;

    protected AbstractItemEntity() { }

    public abstract double calculateTaxes();
}
