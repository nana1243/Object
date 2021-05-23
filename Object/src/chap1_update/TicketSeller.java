package chap1_update;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket= (Ticket) ticketOffice.getTickets();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = (Ticket) ticketOffice.getTickets();
            audience.getBag().minusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

}
