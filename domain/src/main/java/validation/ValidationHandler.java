package validation;

import java.util.List;
import java.util.Objects;

public interface ValidationHandler {

    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);

    ValidationHandler validate(Validation aValidation);

    List<Error> getErrors();

    default boolean hasErrors() {
        return getErrors() != null && !(getErrors().isEmpty());
    }

    default Error firstError() {
        if (Objects.nonNull(getErrors()) && !getErrors().isEmpty()) {
            return getErrors().get(0);
        } else {
            return null;
        }
    }

    interface Validation {
        void validate();
    }

}
