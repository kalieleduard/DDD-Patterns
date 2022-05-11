package item.entity;

import validation.Error;
import validation.ValidationHandler;
import validation.Validator;

import java.util.Objects;

public class ItemValidator extends Validator {

    private final AbstractItemEntity itemEntity;

    protected ItemValidator(final AbstractItemEntity anItem, final ValidationHandler aValidationHandler) {
        super(aValidationHandler);
        this.itemEntity = Objects.requireNonNull(anItem);
    }

    @Override
    public void validate() {
        if (Objects.isNull(this.itemEntity.itemName)) {
            this.validationHandler().append(new Error("Item name shouldn't be NULL"));
        }
    }
}
