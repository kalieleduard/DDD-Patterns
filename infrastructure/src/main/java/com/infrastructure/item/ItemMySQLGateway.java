package com.infrastructure.item;

import com.infrastructure.item.persistence.ItemRepository;
import item.entity.AbstractItemEntity;
import item.entity.ItemGateway;
import item.entity.ItemID;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ItemMySQLGateway implements ItemGateway {

    private final ItemRepository repository;

    public ItemMySQLGateway(final ItemRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public AbstractItemEntity create(AbstractItemEntity anItem) {
        return null;
    }

    @Override
    public void deleteById(ItemID anId) {

    }

    @Override
    public Optional<AbstractItemEntity> findById(ItemID anId) {
        return Optional.empty();
    }

    @Override
    public AbstractItemEntity update(AbstractItemEntity anItem) {
        return null;
    }
}
