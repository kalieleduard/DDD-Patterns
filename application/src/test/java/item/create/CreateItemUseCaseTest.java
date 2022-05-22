package item.create;

import item.entity.ItemCategoryEnum;
import item.entity.ItemGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SuppressWarnings("ConstantConditions")
@ExtendWith(MockitoExtension.class)
public class CreateItemUseCaseTest {

    @InjectMocks
    private DefaultCreateItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @BeforeEach
    void cleanUp() {
        Mockito.reset(this.itemGateway);
    }

    @Test
    @DisplayName("Should return a item ID when given a valid command")
    public void verifyItemReturnedId() {
        final var expectedItemName = "Crystal Water";
        final var expectedAmount = 2;
        final var expectedPrice = 4.0;
        final var expectedCategory = ItemCategoryEnum.DRINK;

        final var aCommand = CreateItemCommand.with(
                expectedItemName,
                expectedPrice,
                expectedAmount,
                expectedCategory
        );

        Mockito.when(itemGateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand).get();

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.getItemID());

        Mockito.verify(itemGateway, times(1))
                .create(Mockito.argThat(anItem ->
                        Objects.nonNull(anItem.getId())
                                && Objects.equals(expectedItemName, anItem.getItemName())
                                && Objects.equals(expectedCategory, anItem.getItemCategory())
                                && Objects.equals(expectedPrice, anItem.getItemPrice())));
    }

    @Test
    @DisplayName("Should throws an Exception when given an invalid item argument")
    public void verifyInvalidItem() {
        final String expectedItemName = null;
        final var expectedAmount = 2;
        final var expectedPrice = 4.0;
        final var expectedCategory = ItemCategoryEnum.DRINK;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "Item name shouldn't be NULL";

        final var aCommand = CreateItemCommand.with(
                expectedItemName,
                expectedPrice,
                expectedAmount,
                expectedCategory
        );

        final var notification = useCase.execute(aCommand).getLeft();

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.firstError().getMessage());

        Mockito.verify(itemGateway, times(0)).create(any());
    }
}
