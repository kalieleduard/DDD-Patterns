package item.retrieve;

import exceptions.DomainException;
import item.entity.ItemCategoryEnum;
import item.entity.ItemGateway;
import item.entity.ItemID;
import item.factory.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GetItemByIdUseCaseTest {

    @InjectMocks
    private DefaultGetItemByIdUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @BeforeEach
    void cleanUp() {
        Mockito.reset(this.itemGateway);
    }

    @Test
    @DisplayName("Should return an item when given a valid updated item")
    public void verifyValidUpdatedItem() {
        final var expectedItemName = "Crystal Water";
        final var expectedPrice = 4.0;
        final var expectedAmount = 2;
        final var expectedCategory = ItemCategoryEnum.DRINK;

        final var anItem = ItemFactory.createItem(
                expectedItemName,
                expectedPrice,
                expectedAmount,
                expectedCategory
        );

        final var expectedId = anItem.getId();

        when(itemGateway.findById(eq(expectedId)))
                .thenReturn(Optional.of(anItem.clone()));

        final var actualItem = useCase.execute(expectedId);

        assertEquals(expectedId, actualItem.getId());
        assertEquals(expectedItemName, actualItem.getName());
        assertEquals(expectedPrice, actualItem.getPrice());
        assertEquals(expectedAmount, actualItem.getAmount());
        assertEquals(expectedCategory, actualItem.getCategory());
    }

    @Test
    @DisplayName("Should throws an exception when given an invalid updated item")
    public void verifyInvalidUpdatedItem() {
        final var expectedErrorMessage = "";
        final var expectedId = ItemID.from("123");

        when(itemGateway.findById(eq(expectedId)))
                .thenReturn(Optional.empty());

        final var actualException = assertThrows(DomainException.class,
                () -> useCase.execute(expectedId));

        assertEquals(expectedErrorMessage, actualException.getMessage());
    }

    @Test
    @DisplayName("Should throws an exception when gateway throws an exception")
    public void verifyGatewayException() {
        final var expectedErrorMessage = "";
        final var expectedId = ItemID.from("123");

        when(itemGateway.findById(eq(expectedId)))
                .thenThrow(new IllegalStateException(expectedErrorMessage));

        final var actualException = assertThrows(DomainException.class,
                () -> useCase.execute(expectedId));

        assertEquals(expectedErrorMessage, actualException.getMessage());
    }
}
