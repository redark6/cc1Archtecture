package ecommercGesture.exposition.memberDTO;

import java.time.LocalDate;

public class ScheduledPaymentDTO {

	public int id;
	public int receiverUserId;
	public PaymentDTO payment;
	public LocalDate datePerformPayment;
	
	private ScheduledPaymentDTO(int id, int receiverUserId, PaymentDTO payment, LocalDate datePerformPayment) {
		this.id = id;
		this.receiverUserId = receiverUserId;
		this.payment = payment;
		this.datePerformPayment = datePerformPayment;
	}
	
	public static ScheduledPaymentDTO of(int id, int receiverUserId, PaymentDTO payment, LocalDate datePerformPayment) {
		return new ScheduledPaymentDTO(id, receiverUserId, payment, datePerformPayment);
	}

	@Override
	public String toString() {
		return "ScheduledPaymentDTO{" + '\'' +
				"id=" + id + '\'' +
				", receiverUserId=" + receiverUserId + '\'' +
				", paymentDTO=" + payment+ '\'' +
				", datePerformPayment=" + '\'' +
				datePerformPayment + "}";
	}
	
}
