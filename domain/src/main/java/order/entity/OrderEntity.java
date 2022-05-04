package order.entity;

import item.entity.AbstractItemEntity;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderEntity {
    private final List<AbstractItemEntity> itemEntities;

    public OrderEntity(List<AbstractItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    public double getTotalPrice() {
        double subtotal = 0;

        for (AbstractItemEntity itemEntity : itemEntities) {
            subtotal += itemEntity.calculateTaxes();
            while (itemEntity.getAmount() > 1) {
                subtotal = verifyItemAmount(subtotal, itemEntity);
            }
        }

        return subtotal;
    }

    public int calculateTotalAmount() {
        return this.itemEntities.stream()
                .reduce(0, (partialSubtotal, itemEntities) ->
                        partialSubtotal + itemEntities.getAmount(), Integer::sum);
    }

    private double verifyItemAmount(double subtotal, AbstractItemEntity itemEntity) {
        itemEntity.setAmount(itemEntity.getAmount() - 1);
        subtotal += itemEntity.calculateTaxes();
        return subtotal;
    }
}
