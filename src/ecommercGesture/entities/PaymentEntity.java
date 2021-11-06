package ecommercGesture.entities;

import java.time.LocalDate;

public class PaymentEntity {
	
	private final int id;
	private final UserEntity user;
	private final double transactionPrice;
	private final LocalDate paymentDate;
	
	private PaymentEntity(int id, UserEntity user, double transactionPrice, LocalDate paymentDate) {
		this.id = id;
		this.user = user;
		this.transactionPrice = transactionPrice;
		this.paymentDate = paymentDate;
	}
	
    public static PaymentEntity of(int id, UserEntity user, double transactionPrice,LocalDate paymentDate) {
        return new PaymentEntity(id, user, transactionPrice, paymentDate);
    }

	public int getId() {
		return id;
	}
	
	public UserEntity getUser() {
		return user;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	
}
