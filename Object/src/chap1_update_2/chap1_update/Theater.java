package chap1_update_2.chap1_update;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }


    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
