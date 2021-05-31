package chap2;

import java.util.List;

public class PercentDiscountPolicy extends  DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(List<DiscountConditions> conditions, double percent) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return Screening.getMovieFee().times(percent);
    }


}
