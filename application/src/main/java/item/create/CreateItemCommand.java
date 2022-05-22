package item.create;

import item.entity.ItemCategoryEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateItemCommand {
    private String name;
    private double price;
    private int amount;
    ItemCategoryEnum itemCategory;

    public static CreateItemCommand with(
            final String aName,
            final double aPrice,
            final int anAmount,
            final ItemCategoryEnum aCategory
    ) {
        return new CreateItemCommand(aName, aPrice, anAmount, aCategory);
    }
}
