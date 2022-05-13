package item.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import root.Identifier;

import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ItemID extends Identifier {
    protected final String id;

    private ItemID(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public static ItemID unique() {
        return ItemID.from(UUID.randomUUID());
    }

    public static ItemID from(final String anId) {
        return new ItemID(anId);
    }

    public static ItemID from(final UUID anId) {
         return new ItemID(anId.toString().toLowerCase());
    }
}
