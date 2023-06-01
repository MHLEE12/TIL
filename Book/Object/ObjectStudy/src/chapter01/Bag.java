package chapter01;

public class Bag {
	
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;
	
	// 캡슐화하여 결합도를 낮추기 위한 메소드 추가
	public Long hold(Ticket ticket) {
		
		if (hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
		
	}
	
	// 내부에서만 사용하니까 public > private 변경
	private boolean hasInvitation() {
		return invitation != null;
	}
	
	// 내부에서만 사용하니까 public > private 변경
	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	// 내부에서만 사용하니까 public > private 변경
	private void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	public void plusAmount(Long amount) {
		this.amount += amount;
	}
	
	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, Long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}
}
