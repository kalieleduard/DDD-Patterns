package item.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Couldn't find the required object, verify if the object is NULL");
    }
}
