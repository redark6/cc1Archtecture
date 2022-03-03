package ecommercGesture.exposition.memberDTO;

import java.time.LocalDate;

public class PaymentDTO {
	
	public int id;
	public int userPayerId;
	public double transactionPrice;
	public LocalDate paymentDate;
	
	private PaymentDTO(int id, int userPayerId, double transactionPrice, LocalDate paymentDate) {
		this.id = id;
		this.userPayerId = userPayerId;
		this.transactionPrice = transactionPrice;
		this.paymentDate = paymentDate;
	}
	
	public static PaymentDTO of(int id, int userPayerId, double transactionPrice, LocalDate paymentDate) {
		return new PaymentDTO(id, userPayerId, transactionPrice, paymentDate);
	}

	@Override
	public String toString() {
		return "PaymentDTO {id=" + id + '\'' +
				", userPayerId=" + userPayerId + '\'' +
				", transactionPrice=" + transactionPrice + '\'' +
				", paymentDate=" + paymentDate + "}";
	}

}
