package chap5;

import chap4.DiscountCondition;
import chap5.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;

    public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions, MovieType movieType) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
        this.movieType = movieType;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee;
    }
}
