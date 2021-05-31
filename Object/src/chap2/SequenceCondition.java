package chap2;

//할인 조건 중 순번 조건
public class SequenceCondition implements DiscountConditions{
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }

}
