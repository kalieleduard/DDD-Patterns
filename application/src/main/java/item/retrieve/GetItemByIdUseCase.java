package item.retrieve;

import item.UseCase;
import item.entity.AbstractItemEntity;
import item.entity.ItemID;

import java.util.Optional;

public abstract class GetItemByIdUseCase extends UseCase<ItemID, Optional<AbstractItemEntity>> {

}
