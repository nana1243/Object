package chap1_update;

//관람객은 가방을 소지할 수 있
public class Audience {
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }


    public Bag getBag() {
        return bag;
    }

}
