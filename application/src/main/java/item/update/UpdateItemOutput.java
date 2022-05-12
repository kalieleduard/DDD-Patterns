package item.update;

import item.entity.AbstractItemEntity;
import item.entity.ItemID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateItemOutput {
    private ItemID itemID;

    public static UpdateItemOutput from(final AbstractItemEntity anItem) {
        return new UpdateItemOutput(anItem.getId());
    }
}
