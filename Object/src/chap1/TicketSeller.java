package chap1;

public class TicketSeller {
    // 판매자는 자신이 일하는 매표소를 알고 있어야한다.
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
