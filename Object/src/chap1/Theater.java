package chap1;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }


    public void enter(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = (Ticket) ticketSeller.getTicketOffice().getTickets();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = (Ticket) ticketSeller.getTicketOffice().getTickets();
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
