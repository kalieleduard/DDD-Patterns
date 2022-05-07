package item.entity;

import java.util.Optional;

public interface ItemGateway {

    AbstractItemEntity create(AbstractItemEntity anItem);

    void deleteById(ItemID anId);

    Optional<AbstractItemEntity> findById(ItemID anId);

    AbstractItemEntity update(AbstractItemEntity anItem);

}
