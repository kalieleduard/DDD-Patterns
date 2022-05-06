package order;

import item.entity.*;
import order.entity.OrderEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderEntityUTest {
    private OrderEntity order;

    @Test
    @DisplayName("Should calculate the subtotal from the specific order with applied taxes")
    public void verifyOrderPriceSubtotal() {
        List<AbstractItemEntity> itemEntityList = this.mockItemEntityList();
        this.order = new OrderEntity(itemEntityList);
        assertEquals(232.42, this.order.getTotalPrice());
    }

    @Test
    @DisplayName("Should calculate the total amount of tha category items")
    public void verifyItemAmount() {
        List<AbstractItemEntity> itemEntityList = this.mockItemEntityList();
        this.order = new OrderEntity(itemEntityList);
        assertEquals(4, this.order.calculateTotalAmount());
    }

    private List<AbstractItemEntity> mockItemEntityList() {
        return List.of(
                new ElectronicItemEntity(ItemID.unique(), "Play 2", 200.0, 1),
                new DrinkItemEntity(ItemID.unique(), "Crystal", 2, 1),
                new FoodItemEntity(ItemID.unique(), "Hot Dog", 10, 2)
        );
    }
}
