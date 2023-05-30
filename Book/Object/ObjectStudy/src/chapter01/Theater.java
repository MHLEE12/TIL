package chapter01;

public class Theater {
	
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public void enter(Audience audience) {
		
		// 문제있던 기존 코드 -> 자율성을 높이기 위해 TicketSeller 내부로 숨기기
//		if(audience.getBag().hasInvitation()) {
//			
//			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//			audience.getBag().setTicket(ticket);
//			
//		} else {
//			
//			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//			audience.getBag().minusAmount(ticket.getFee());
//			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//			audience.getBag().setTicket(ticket);
//			
//		}
		
		// 개선
		ticketSeller.sellTo(audience);
	}
	
	
}
