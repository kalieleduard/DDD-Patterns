package com.infrastructure.item.persistence;

import item.entity.AbstractItemEntity;
import item.entity.ItemCategoryEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item")
public class ItemJpaEntity {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String itemName;

    @Column(name = "price", nullable = false)
    private double itemPrice;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "category", nullable = false)
    private ItemCategoryEnum itemCategory;

    public ItemJpaEntity() { }

    private ItemJpaEntity(
            final String id,
            final String itemName,
            final double itemPrice,
            final int amount,
            final ItemCategoryEnum itemCategory) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
        this.itemCategory = itemCategory;
    }

    public static ItemJpaEntity from(final AbstractItemEntity anItem) {
        return new ItemJpaEntity(
                String.valueOf(anItem.getId()),
                anItem.getItemName(),
                anItem.getItemPrice(),
                anItem.getAmount(),
                anItem.getItemCategory()
        );
    }
}
