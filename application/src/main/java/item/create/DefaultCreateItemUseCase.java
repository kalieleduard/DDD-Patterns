package item.create;

import io.vavr.control.Either;
import item.entity.AbstractItemEntity;
import item.entity.ItemGateway;
import item.factory.ItemFactory;
import validation.handler.Notification;

import java.util.Objects;

import static io.vavr.API.*;

public class DefaultCreateItemUseCase extends CreateItemUseCase {

    private final ItemGateway itemGateway;

    public DefaultCreateItemUseCase(final ItemGateway itemGateway) {
        this.itemGateway = Objects.requireNonNull(itemGateway);
    }

    @Override
    public Either<Notification, CreateItemOutput> execute(final CreateItemCommand aCommand) {
        final var aName = aCommand.getName();
        final var aPrice = aCommand.getPrice();
        final var anAmount = aCommand.getAmount();
        final var aCategory = aCommand.getItemCategory();

        final var notification = Notification.create();

        final var anItem = ItemFactory.createItem(
                aName,
                aPrice,
                anAmount,
                aCategory
        );

        anItem.validate(notification);

        return notification.hasErrors() ? Left(notification) :  create(anItem);
    }

    private Either<Notification, CreateItemOutput> create(final AbstractItemEntity anItem) {
        return Try(() -> this.itemGateway.create(anItem))
                .toEither()
                .bimap(Notification::create, CreateItemOutput::from);
    }
}
