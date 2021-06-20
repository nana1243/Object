package chap5;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    //영화를 예매하기 위해서는 `moive에게 가격을 계산하라` 메세지를 전송
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, calculateFee(audienceCount) ,audienceCount);

    }
    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
