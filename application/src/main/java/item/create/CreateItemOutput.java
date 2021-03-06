package item.create;

import item.entity.AbstractItemEntity;
import item.entity.ItemID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateItemOutput {
    private ItemID itemID;

    public static CreateItemOutput from(final AbstractItemEntity anItem) {
        return new CreateItemOutput(anItem.getId());
    }
}
