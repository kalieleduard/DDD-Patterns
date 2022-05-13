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

import java.util.Objects;
import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@SuppressWarnings("ConstantConditions")
@ExtendWith(MockitoExtension.class)
public class UpdateItemUseCaseTest {

    @InjectMocks
    private DefaultUpdateItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @Test
    @DisplayName("Should return a valid item when created a new Item with valid arguments")
    public void verifyItemCreationWhenGivenAValidCommand() {
        final var anItem = ItemFactory.createItem(
                "Waters",
                2,
                2,
                null
        );

        final var expectedItemName = "Crystal Water";
        final var expectedPrice = 4.0;
        final var expectedAmount = 2;
        final var expectedCategory = ItemCategoryEnum.DRINK;

        final var expectedId = anItem.getId();

        final var aCommand = UpdateItemCommand.with(
                expectedId,
                anItem.getItemName(),
                anItem.getItemPrice(),
                anItem.getAmount(),
                anItem.getItemCategory()
        );

        when(itemGateway.findById(eq(expectedId)))
                .thenReturn(Optional.of(anItem));

        when(itemGateway.update(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand).get();

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.getId());

        Mockito.verify(itemGateway, times(1)).findById(eq(expectedId));

        Mockito.verify(itemGateway, times(1)).update(argThat(
                anUpdatedItem ->
                        Objects.equals(expectedItemName, anItem.getItemName())
                                && Objects.equals(expectedId, anUpdatedItem.getId())
                                && Objects.equals(expectedPrice, anUpdatedItem.getItemPrice())
                                && Objects.equals(expectedAmount, anUpdatedItem.getAmount())
                                && Objects.equals(expectedCategory, anUpdatedItem.getItemCategory())
        ));

    }
}