package chap4;

import java.time.Duration;
import java.util.List;

/*
데이터 중심의 설계
- 차이점은 discountAmount, discountPercent

 */

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditionList;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;


    public Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditionList() {
        return discountConditionList;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
