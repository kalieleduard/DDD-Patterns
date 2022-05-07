package item.create;

import item.entity.ItemCategoryEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CreateItemCommand {
    private String name;
    private double price;
    private int amount;
    private ItemCategoryEnum itemCategory;

    public static CreateItemCommand with(
            final String aName,
            final double aPrice,
            final int anAmount,
            final ItemCategoryEnum aCategory
    ) {
        return new CreateItemCommand(aName, aPrice, anAmount, aCategory);
    }
}
