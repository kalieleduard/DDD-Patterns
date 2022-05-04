package item;

import item.entity.AbstractItemEntity;
import item.entity.ItemCategoryEnum;
import factory.ItemFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemEntityUTest {
    private AbstractItemEntity itemEntity;

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
}
