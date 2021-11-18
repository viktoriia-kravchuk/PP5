package pl.kravchuk.carddatabase;

import org.junit.jupiter.api.Test;
import pl.kravchuk.creditcard.CreditCard;
import static org.junit.jupiter.api.Assertions.*;

public class CardDatabaseTest {
    @Test
    public void itStoreCard() {
        CardDatabase memory = new CardDatabase();
        CreditCard card = new CreditCard("123");

        memory.save(card);

        CreditCard loaded = memory.findByNumber("123")
                .get();

        assertEquals(card.getNumber(), loaded.getNumber());
    }
}
