package chapter01;

public class Audience {
	
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	// bag의 존재를 audience 내부로 캡슐화 함
	public Long buy(Ticket ticket) {
		// 지불된 금액 반환
		
		// Bag 클래스 캡슐화로 인해 삭제하는 코드
//		if (bag.hasInvitation()) {
//			
//			bag.setTicket(ticket);
//			return 0L;
//			
//		} else {
//			
//			bag.setTicket(ticket);
//			bag.minusAmount(ticket.getFee());
//			return ticket.getFee();
//			
//		}
		
		// Bag클래스의 구현이 아닌 인터페이스에만 의존하도록 수정됨
		return bag.hold(ticket);
		
	}
	
}
