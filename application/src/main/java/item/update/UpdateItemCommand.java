package item.update;

import item.entity.ItemCategoryEnum;
import item.entity.ItemID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateItemCommand {
    private ItemID id;
    private String itemName;
    private double itemPrice;
    private int itemAmount;
    private ItemCategoryEnum itemCategory;

    public static UpdateItemCommand with(
            final ItemID anId,
            final String aName,
            final double aPrice,
            final int anAmount,
            final ItemCategoryEnum itemCategory
    ) {
        return new UpdateItemCommand(anId, aName, aPrice, anAmount, itemCategory);
    }
}
