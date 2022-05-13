package item.create;

import io.vavr.control.Either;
import item.UseCase;
import validation.handler.Notification;

public abstract class CreateItemUseCase extends UseCase<CreateItemCommand, Either<Notification, CreateItemOutput>> { }
