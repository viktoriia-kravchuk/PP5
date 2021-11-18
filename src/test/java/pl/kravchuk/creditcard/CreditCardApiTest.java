package pl.kravchuk.creditcard;

import  org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static  org.junit.jupiter.api.Assertions.*;

public class CreditCardApiTest {

    private CreditCardMemory cardMemory;

    @Test
    public void itAllowsToHandleCreditCardWithdrawFromMultipleCards() {

        thereIsCreditCardMemory();

        String cardNumber1 = thereIsCardWithLimitInTheSystem(1000);
        String cardNumber2 = thereIsCardWithLimitInTheSystem(2000);

        CardApi system = thereIsBankingSystem();

        system.handleWithdraw(cardNumber1, 500);
        system.handleWithdraw(cardNumber2, 1000);

        balanceOfCardEquals(cardNumber1, 500);
        balanceOfCardEquals(cardNumber2, 1000);
    }

    private CardApi thereIsBankingSystem() {
        return new CardApi(cardMemory);
    }

    private void balanceOfCardEquals(String cardNumber, int expectedBalance) {
        CreditCard loaded = cardMemory.findByNumber(cardNumber)
            .orElseGet(() -> new CreditCard(cardNumber));

        assertEquals(BigDecimal.valueOf(expectedBalance), loaded.getBalance());
    }

    private String thereIsCardWithLimitInTheSystem(int creditLimit) {


        CreditCard card = new CreditCard((UUID.randomUUID().toString()));
        card.assignCredit(BigDecimal.valueOf(creditLimit));

        cardMemory.save(card);

        return card.getNumber();

    }

    private void thereIsCreditCardMemory() {
        cardMemory = new CreditCardMemory();
    }
}
