package item.create;

import item.entity.ItemGateway;
import item.factory.ItemFactory;

import java.util.Objects;

public class DefaultCreateItemUseCase extends CreateItemUseCase {

    private final ItemGateway itemGateway;

    public DefaultCreateItemUseCase(final ItemGateway itemGateway) {
        this.itemGateway = Objects.requireNonNull(itemGateway);
    }

    @Override
    public CreateItemOutput execute(final CreateItemCommand aCommand) {
        final var aName = aCommand.getName();
        final var aPrice = aCommand.getPrice();
        final var anAmount = aCommand.getAmount();
        final var aCategory = aCommand.getItemCategory();

        final var anItem = ItemFactory.createItem(
                aName,
                aPrice,
                anAmount,
                aCategory
        );

        return CreateItemOutput.from(this.itemGateway.create(anItem));
    }
}
