package chap1_update_2.chap1_update;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    public void sellTo(Audience audience){
        ticketOffice.plusAmount(audience.buy((Ticket) ticketOffice.getTickets()));
    }

}
