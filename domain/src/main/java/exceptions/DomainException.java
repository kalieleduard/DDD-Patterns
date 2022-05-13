package exceptions;

import validation.Error;

import java.util.List;
import java.util.Objects;

public class DomainException extends NoStackTraceException {

    private final List<Error> errors;

    private DomainException(final List<Error> anErrors) {
        super("");
        this.errors = Objects.requireNonNull(anErrors);
    }


    public static DomainException with(final Error anError) {
        return new DomainException(List.of(anError));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException(anErrors);

    }
    public List<Error> getErrors() {
        return errors;
    }
}
