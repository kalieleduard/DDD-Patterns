package item.retrieve;

import item.entity.AbstractItemEntity;
import item.entity.ItemGateway;
import item.entity.ItemID;

import java.util.Objects;
import java.util.Optional;

public class DefaultGetItemByIdUseCase extends GetItemByIdUseCase {

    private final ItemGateway itemGateway;

    public DefaultGetItemByIdUseCase(final ItemGateway itemGateway) {
        this.itemGateway = Objects.requireNonNull(itemGateway);
    }

    @Override
    public Optional<AbstractItemEntity> execute(ItemID anIn) {
        return this.itemGateway.findById(anIn);
    }
}
