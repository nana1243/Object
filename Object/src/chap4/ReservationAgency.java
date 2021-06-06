package chap4;

public class ReservationAgency {

    public  Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Movie movie = screening.getMovie();

        boolean discountable = false;

        for (DiscountCondition condition : movie.getDiscountConditionList()){
            if(condition.getType() == DiscountConditionType.PERIOD){
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime())>=0;

            }else{
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable){
                break;
            }
        }
        Money fee;
        if (discountable){
            Money discountAmount = Money.Zero;
            switch (movie.getMovieType()){
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountAmount());
                    break;

                case NONE_DISCOUNT:
                    discountAmount = Money.Zero;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        }else{
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);

    }

}
