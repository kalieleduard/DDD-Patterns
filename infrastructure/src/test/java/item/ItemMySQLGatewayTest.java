package item;

import com.infrastructure.item.ItemMySQLGateway;
import com.infrastructure.item.persistence.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*[MySQLGateway]")
})
public class ItemMySQLGatewayTest {

    @Autowired
        private ItemMySQLGateway itemMySQLGateway;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testInjectedDependencies() {
        Assertions.assertNotNull(itemMySQLGateway);
        Assertions.assertNotNull(itemRepository);
    }
}
