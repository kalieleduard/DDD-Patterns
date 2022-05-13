package item.update;

import exceptions.DomainException;
import io.vavr.control.Either;
import item.entity.AbstractItemEntity;
import item.entity.ItemGateway;
import item.entity.ItemID;
import validation.Error;
import validation.handler.Notification;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultUpdateItemUseCase extends UpdateItemUseCase {

    private final ItemGateway itemGateway;

    public DefaultUpdateItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = Objects.requireNonNull(itemGateway);
    }

    @Override
    public Either<Notification, UpdateItemOutput> execute(final UpdateItemCommand aCommand) {
        final var anId = ItemID.from(aCommand.getItemName());
        final var aName = aCommand.getItemName();
        final var aPrice = aCommand.getItemPrice();
        final var anAmount = aCommand.getItemAmount();
        final var aCategory = aCommand.getItemCategory();

        final var anItem = this.itemGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();

        anItem.update(aName, aPrice, anAmount, aCategory)
                .validate(notification);

        return notification.hasErrors() ? Left(notification) : update(anItem);
    }

    private Either<Notification, UpdateItemOutput> update(final AbstractItemEntity anItem) {
        return Try(() -> this.itemGateway.update(anItem))
                .toEither()
                .bimap(Notification::create, UpdateItemOutput::from);
    }

    private Supplier<DomainException> notFound(final ItemID anId) {
        return () -> DomainException.with(
                new Error(String.format("Item with ID %s was not found", (anId)))
        );
    }
}
