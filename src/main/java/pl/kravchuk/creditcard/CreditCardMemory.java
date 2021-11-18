package pl.kravchuk.creditcard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CreditCardMemory implements CardMemory {
    Map<String, CreditCard> cards;

    public CreditCardMemory() {
        this.cards = new HashMap<>();
    }

    @Override
    public void save(CreditCard card) {
        cards.put(card.getNumber(), card);
    }

    @Override
    public Optional<CreditCard> findByNumber(String cardNumber) {
        return Optional.of(cards.get(cardNumber));
    }
}
