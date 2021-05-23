package chap1_update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//초대장을 티켓으로 교환해주거나, 판매해주는 역할을 하는 객
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>(); //

    public TicketOffice(Long amount, Ticket tickets){
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void minusAmount(Long amount){
        this.amount-=amount;
    }

    public void plusAmount(Long amount){
        this.amount+= amount;
    }
}
