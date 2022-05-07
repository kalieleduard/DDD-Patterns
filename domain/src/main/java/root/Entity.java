package root;

import java.util.Objects;

public class Entity<ID extends Identifier> {
    protected final ID id;

    public Entity(ID id) {
        Objects.requireNonNull(id, "'ID' Shouldn't be NULL");
        this.id = id;
    }

    public ID getId() {
        return this.id;
    }
}
