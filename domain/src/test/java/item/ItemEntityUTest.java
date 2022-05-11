package item;

import exceptions.DomainException;
import item.entity.AbstractItemEntity;
import item.entity.ItemCategoryEnum;
import item.factory.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.handler.ThrowsValidationHandler;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
public class ItemEntityUTest {
    private AbstractItemEntity itemEntity;

    @BeforeEach
    public void init() {
        itemEntity = null;
    }

    @Test
    @DisplayName("Should calculate the electronic item tax")
    public void verifyCorrectlyElectronicItemTax() {
        final var expectedItemName = "Playstation 2";
        final var expectedItemPrice = 20;
        final var expectedItemAmount = 1;
        final var expectedItemCategory = ItemCategoryEnum.ELECTRONIC;

        this.itemEntity = ItemFactory.createItem(
                expectedItemName,
                expectedItemPrice,
                expectedItemAmount,
                expectedItemCategory
        );

        double tax = this.itemEntity.calculateTaxes();
        assertEquals(21, tax);
        assertNotNull(this.itemEntity);
        assertNotNull(this.itemEntity.getItemName());
        assertNotNull(this.itemEntity.getItemCategory());
        assertEquals(expectedItemName, this.itemEntity.getItemName());
        assertEquals(expectedItemPrice, this.itemEntity.getItemPrice());
        assertEquals(expectedItemAmount, this.itemEntity.getAmount());
        assertEquals(expectedItemCategory, this.itemEntity.getItemCategory());
    }

    @Test
    @DisplayName("Should calculate the food item tax")
    public void verifyCorrectlyFoodItemTax() {
        final var expectedItemName = "Pasta";
        final var expectedItemPrice = 40;
        final var expectedItemAmount = 1;
        final var expectedItemCategory = ItemCategoryEnum.FOOD;

        this.itemEntity = ItemFactory.createItem(
                expectedItemName,
                expectedItemPrice,
                expectedItemAmount,
                expectedItemCategory
        );

        double tax = this.itemEntity.calculateTaxes();
        assertEquals(40.8, tax);
    }

    @Test
    @DisplayName("Should calculate the drink item tax")
    public void verifyCorrectlyDrinkItemTax() {
        final var expectedItemName = "Crystal Water";
        final var expectedItemPrice = 60;
        final var expectedItemAmount = 1;
        final var expectedItemCategory = ItemCategoryEnum.DRINK;

        this.itemEntity = ItemFactory.createItem(
                expectedItemName,
                expectedItemPrice,
                expectedItemAmount,
                expectedItemCategory
        );

        double tax = this.itemEntity.calculateTaxes();
        assertEquals(60.6, tax);
    }

    @Test
    @DisplayName("Should throws an error when given a NULL item name")
    public void verifyInvalidItemName() {
        final String expectedItemName = null;
        final var expectedItemPrice = 20;
        final var expectedItemAmount = 1;
        final var expectedItemCategory = ItemCategoryEnum.ELECTRONIC;
        final var expectedErrorMessage = "Item name shouldn't be NULL";
        final var expectedErrorCount = 1;

        this.itemEntity = ItemFactory.createItem(
                expectedItemName,
                expectedItemPrice,
                expectedItemAmount,
                expectedItemCategory
        );

        final var actualException = assertThrows(DomainException.class,
                () -> this.itemEntity.validate(new ThrowsValidationHandler()));

        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).getMessage());
        assertEquals(expectedErrorCount, actualException.getErrors().size());
    }
}
