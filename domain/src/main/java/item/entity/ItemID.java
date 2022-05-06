package item.entity;

import root.Identifier;

import java.util.UUID;

public class ItemID extends Identifier {
    protected final String id;

    private ItemID(String id) {
        this.id = id;
    }

    public static ItemID unique() {
        return new ItemID(UUID.randomUUID().toString().toLowerCase());
    }
}
