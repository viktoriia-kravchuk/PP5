package pl.kravchuk.creditcard;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CardApi {

    private final CreditCardMemory memory;

    public CardApi(CreditCardMemory memory) {
        this.memory = memory;
    }

    public void handleWithdraw(String cardNumber, int money) {
        CreditCard card = memory.findByNumber(cardNumber).get();
        card.withdraw(BigDecimal.valueOf(money));

        memory.save(card);
    }

    public List<String> cards() {
        return Arrays.asList(
                "number 1",
                "number 2"
        );
    }
}
