package item.create;

import item.entity.ItemCategoryEnum;
import item.entity.ItemGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseTest {

    @InjectMocks
    private DefaultCreateItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

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

        Mockito.when(itemGateway.create(Mockito.any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.getItemID());

        Mockito.verify(itemGateway, Mockito.times(1))
                .create(Mockito.argThat(anItem ->
                        Objects.nonNull(anItem.getId())
                                && Objects.equals(expectedItemName, anItem.getItemName())
                                && Objects.equals(expectedCategory, anItem.getItemCategory())
                                && Objects.equals(expectedPrice, anItem.getItemPrice())));
    }
}
