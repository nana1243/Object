package chap2;

import java.util.List;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(List<DiscountConditions> conditions, Money discountAmount) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return discountAmount;
    }
}
