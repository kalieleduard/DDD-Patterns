package item.update;

import item.entity.ItemCategoryEnum;
import item.entity.ItemGateway;
import item.factory.ItemFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateItemUseCaseTest {

    @InjectMocks
    private DefaultUpdateItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @Test
    @DisplayName("When called update use case should return a valid ID")
    public void verifyItemReturnedIdWhenCalledUpdateUseCase() {
        final var aItem = ItemFactory.createItem(
                "Water",
                0,
                2,
                ItemCategoryEnum.FOOD
        );

        final var expectedItemName = "Crystal Water";
        final var expectedPrice = 4.0;
        final var expectedAmount = 2;
        final var expectedCategory = ItemCategoryEnum.DRINK;


        final var expectedId = aItem.getId();

        final var aCommand = UpdateItemCommand.with(
                expectedId,
                expectedItemName,
                expectedPrice,
                expectedAmount,
                expectedCategory
        );

        when(itemGateway.findById(eq(expectedId)))
                .thenReturn(Optional.of(aItem));

        when(itemGateway.update(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand).get();

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.getId());

        Mockito.verify(itemGateway, times(1)).findById(eq(expectedId));
        Mockito.verify(itemGateway, times(1)).update(argThat(anUpdatedItem -> {

        }))
    }
}
