package root;

import lombok.EqualsAndHashCode;
import validation.ValidationHandler;

import java.util.Objects;

@EqualsAndHashCode
public abstract class Entity<ID extends Identifier> {
    protected final ID id;

    public Entity(final ID anId) {
        Objects.requireNonNull(anId, "'ID' Shouldn't be NULL");
        this.id = anId;
    }

    public ID getId() {
        return this.id;
    }

    public abstract void validate(ValidationHandler handler);
}
