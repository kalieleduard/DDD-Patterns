package item;

import item.entity.AbstractItemEntity;
import item.entity.ItemCategoryEnum;
import item.factory.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ItemEntityUTest {
    private AbstractItemEntity itemEntity;

    @BeforeEach
    public void init() {
        itemEntity = null;
    }

    @Test
    @DisplayName("Should calculate the electronic item tax")
    public void verifyCorrectlyElectronicItemTax() {
        this.itemEntity = ItemFactory.makeItemByType(ItemCategoryEnum.ELECTRONIC);
        this.itemEntity.setItemPrice(20);
        double tax = this.itemEntity.calculateTaxes();
        assertEquals(21, tax);
    }

    @Test
    @DisplayName("Should calculate the food item tax")
    public void verifyCorrectlyFoodItemTax() {
        this.itemEntity = ItemFactory.makeItemByType(ItemCategoryEnum.FOOD);
        this.itemEntity.setItemPrice(40);
        double tax = this.itemEntity.calculateTaxes();
        assertEquals(40.8, tax);
    }

    @Test
    @DisplayName("Should calculate the drink item tax")
    public void verifyCorrectlyDrinkItemTax() {
        this.itemEntity = ItemFactory.makeItemByType(ItemCategoryEnum.DRINK);
        this.itemEntity.setItemPrice(60);
        double tax = this.itemEntity.calculateTaxes();
        assertEquals(60.6, tax);
    }

    @Test
    @DisplayName("Should throw a exception when the required item has no values or it's empty")
    public void shouldThrowAExceptionWhenTheItemIsNull() {
        String itemType = "null_testable";
        for (ItemCategoryEnum value : ItemCategoryEnum.values()) {
            if (itemType.equals(value.toString())) {
                this.itemEntity = ItemFactory.makeItemByType(value);
            }
        }

        final var exception = new IllegalArgumentException();

        assertTrue(Objects.isNull(this.itemEntity));
        assertThrows(exception.getClass(), () -> ItemFactory.makeItemByType(ItemCategoryEnum.valueOf(itemType)));
    }
}
