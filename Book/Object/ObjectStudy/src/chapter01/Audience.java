package chapter01;

public class Audience {
	
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	// bag의 존재를 audience 내부로 캡슐화 함
	public Long buy(Ticket ticket) {
		// 지불된 금액 반환
		
		if (bag.hasInvitation()) {
			
			bag.setTicket(ticket);
			return 0L;
			
		} else {
			
			bag.setTicket(ticket);
			bag.minusAmount(ticket.getFee());
			return ticket.getFee();
			
		}
		
	}
	
}
