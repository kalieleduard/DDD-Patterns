package validation;

import java.util.Objects;

public abstract class Validator {

    private final ValidationHandler validationHandler;

    protected Validator(final ValidationHandler validationHandler) {
        this.validationHandler = Objects.requireNonNull(validationHandler);
    }

    protected ValidationHandler validationHandler() {
        return this.validationHandler;
    }

    public abstract void validate();
}
