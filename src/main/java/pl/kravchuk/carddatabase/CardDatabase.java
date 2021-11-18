package pl.kravchuk.carddatabase;

import pl.kravchuk.creditcard.CardMemory;
import pl.kravchuk.creditcard.CreditCard;

import java.util.Optional;

public class CardDatabase implements CardMemory {
    @Override
    public void save(CreditCard card) {

    }

    @Override
    public Optional<CreditCard> findByNumber(String s) {
        return Optional.empty();
    }
}
