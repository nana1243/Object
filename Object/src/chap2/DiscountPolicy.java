package chap2;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountConditions> conditions = new ArrayList<>();

    public DiscountPolicy(List<DiscountConditions> conditions) {
        this.conditions = conditions;
    }

    public Money calculateDiscountAmount(Screening screening) {

        for(DiscountConditions each : conditions){
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);


}
