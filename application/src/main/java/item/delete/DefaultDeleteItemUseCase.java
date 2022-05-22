package item.delete;

import item.entity.ItemGateway;
import item.entity.ItemID;

import java.util.Objects;

public class DefaultDeleteItemUseCase extends DeleteItemUseCase {

    private final ItemGateway itemGateway;

    public DefaultDeleteItemUseCase(final ItemGateway itemGateway) {
        this.itemGateway = Objects.requireNonNull(itemGateway);
    }

    @Override
    public void execute(final String anId) {
        this.itemGateway.deleteById(ItemID.from(anId));
    }
}
