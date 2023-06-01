package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
	
	private Long amount;
	private List<Ticket> tickets = new ArrayList<>();
	
	public TicketOffice(Long amount, Ticket ... tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets));
	}

	// 내부에서만 사용하니까 public > private 변경
	private Ticket getTicket() {
		return tickets.remove(0);
	}
	
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	// 내부에서만 사용하니까 public > private 변경
	private void plusAmount(Long amount) {
		this.amount += amount;
	}
	
	// TicketOffice에 자율권을 주는 코드
	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}
	
}
