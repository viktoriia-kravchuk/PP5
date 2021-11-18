package pl.kravchuk.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private static final int CREDIT_LOW_LIMIT = 100;
    private final String cardNumber;
    private BigDecimal creditLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignCredit(BigDecimal creditLimit) {
        if (isBelowCreditLimit(creditLimit)) {
            throw new CreditBelowLimitException();
        }
        this.creditLimit = creditLimit;
        balance = creditLimit;
    }

    private boolean isBelowCreditLimit(BigDecimal creditLimit) {
        return creditLimit.compareTo(BigDecimal.valueOf(CREDIT_LOW_LIMIT)) < 0;
    }

    public BigDecimal getCurrentLimit() {
        return creditLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) < 0) {
            throw new NotEnoughMoneyException();
        }
        this.balance = balance.subtract(money);
    }


    public String getNumber() {
        return cardNumber;
    }
}
