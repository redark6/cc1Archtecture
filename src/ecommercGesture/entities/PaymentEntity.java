package ecommercGesture.entities;

import java.time.LocalDate;
import java.util.Objects;

public class PaymentEntity {
	
	private final int id;
	private final Member member;
	private final double transactionPrice;
	private final LocalDate paymentDate;
	
	private PaymentEntity(int id, Member member, double transactionPrice, LocalDate paymentDate) {
		this.id = id;
		this.member = Objects.requireNonNull(member,"Buyer id must be not null");
		this.transactionPrice = Objects.requireNonNull(transactionPrice,"Transaction price must be not null");
		this.paymentDate = Objects.requireNonNull(paymentDate,"Payment date must be not null");
	}
	
    public static PaymentEntity of(int id, Member member, double transactionPrice,LocalDate paymentDate) {
        return new PaymentEntity(id, member, transactionPrice, paymentDate);
    }

	public int getId() {
		return id;
	}
	
	public Member getMember() {
		return member;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", member=" + member + ", transactionPrice=" + transactionPrice
				+ ", paymentDate=" + paymentDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(transactionPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentEntity other = (PaymentEntity) obj;
		if (id != other.id)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (Double.doubleToLongBits(transactionPrice) != Double.doubleToLongBits(other.transactionPrice))
			return false;
		return true;
	}
	
}
