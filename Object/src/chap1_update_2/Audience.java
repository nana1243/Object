package chap1_update_2;

//관람객은 가방을 소지할 수 있
public class Audience {
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }


//    public Bag getBag() {
//        return bag;
//    }

    public Long buy(Ticket ticket){
        return bag.hold(ticket);
    }


}
