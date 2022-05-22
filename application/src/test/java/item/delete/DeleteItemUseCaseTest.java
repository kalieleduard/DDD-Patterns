package item.delete;

import item.entity.ItemCategoryEnum;
import item.entity.ItemGateway;
import item.entity.ItemID;
import item.factory.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeleteItemUseCaseTest {

    @InjectMocks
    private DefaultDeleteItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @BeforeEach
    void cleanUp() {
        Mockito.reset(this.itemGateway);
    }

    @Test
    @DisplayName("Should delete some item entity when called delete item")
    public void verifyValidDeletion() {
        final var aItem = ItemFactory.createItem(
                "Cigar",
                10,
                1,
                ItemCategoryEnum.FOOD
        );

        final var expectedId = aItem.getId();

        doNothing()
                .when(itemGateway).deleteById(eq(expectedId));

        assertDoesNotThrow(() -> useCase.execute(expectedId.getId()));

        verify(itemGateway, times(1)).deleteById(eq(expectedId));
    }

    @Test
    @DisplayName("Shouldn't delete a given item entity and return OK")
    public void verifyInvalidDeletion() {
        final var expectedId = ItemID.from("123");

        doNothing()
                .when(itemGateway).deleteById(eq(expectedId));

        assertDoesNotThrow(() -> useCase.execute(expectedId.getId()));

        verify(itemGateway, times(1)).deleteById(eq(expectedId));
    }

    @Test
    @DisplayName("Should throws an exception when occurs an gateway error")
    public void verifyGatewayException() {
        final var aItem = ItemFactory.createItem(
                "Cigar",
                10,
                1,
                ItemCategoryEnum.FOOD
        );

        final var expectedId = aItem.getId();

        doThrow(new IllegalStateException("Gateway Error"))
                .when(itemGateway).deleteById(eq(expectedId));

        assertThrows(IllegalStateException.class, () -> useCase.execute(expectedId.getId()));

        verify(itemGateway, times(1)).deleteById(eq(expectedId));
    }
}
