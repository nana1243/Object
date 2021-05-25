package chap1_update_2;

/*
* 1. 이벤트에 당첨된 사람은 가방안에 현금과 초대장이 들어있지만,
* 2. 이벤트에 당첨되지 않은 사람은 가방안에 초대장은 없다.
* */
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // 이벤트에 당첨되지 않은 사람의 가방 객체 생성자
    public Bag(Long amount) {
        this.amount = amount;
    }

    // 이벤트에 당첨된 사람의 가방 객체 생성자
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }


    public boolean hasInvitation(){
        return invitation!=null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount){
        this.amount -=amount;
    }


}
