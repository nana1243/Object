package chap1_update;

import chap1_update.Audience;
import chap1_update.Ticket;
import chap1_update.TicketSeller;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }


    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
