package item.update;

import io.vavr.control.Either;
import item.UseCase;
import validation.handler.Notification;

public abstract class UpdateItemUseCase extends UseCase<UpdateItemCommand, Either<Notification, UpdateItemOutput>> { }
