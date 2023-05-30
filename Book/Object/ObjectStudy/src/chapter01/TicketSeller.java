package chapter01;

public class TicketSeller {
	
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	// ticketSeller의 자율성을 높이기 위해 삭제됨
//	public TicketOffice getTicketOffice() {
//		return ticketOffice;
//	}
	
	// 자율성을 높히기 위해 Theater에 있던 코드를 옮김
	public void sellTo(Audience audience) {
		
		if(audience.getBag().hasInvitation()) {
			
			Ticket ticket = ticketOffice.getTicket();
			audience.getBag().setTicket(ticket);
			
		} else {
			
			Ticket ticket = ticketOffice.getTicket();
			audience.getBag().minusAmount(ticket.getFee());
			ticketOffice.plusAmount(ticket.getFee());
			audience.getBag().setTicket(ticket);
			
		}
		
	}

}
