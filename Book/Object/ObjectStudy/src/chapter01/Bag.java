package chapter01;

public class Bag {
	
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;
	
	public boolean hasInvitation() {
		return invitation != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	public void plusAmount(Long amount) {
		this.amount += amount;
	}
	
//	public Bag(long amount) {
//		
//		this(null, amount);
//	}
//
//	public Bag(Invitaion invitation, long amount) {
//		this.invitation = invitaion;
//		this.amount = amount;
//	}
}
