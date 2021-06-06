package chap4;

import java.math.BigDecimal;

public class Money {
    public static Money Zero;
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }



    public Money times(Money percent) {
        return new Money(this.amount.multiply(percent.amount));
    }


    public Money minus(Money amount) {

        return new Money(this.amount.subtract(amount.amount));
    }
}
