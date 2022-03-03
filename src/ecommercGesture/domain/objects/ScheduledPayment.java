package ecommercGesture.domain.objects;

import java.time.LocalDate;

public class ScheduledPayment {

    private final Id id;
    private final Id receiverUserId;
    private Payment payment;
    private BillingInformation billingInformationPayer;
    private BillingInformation billingInformationReceiver;
    private LocalDate datePerformPayement;
	
	private ScheduledPayment(Id id, Id receiverUserId, Payment payment, BillingInformation billingInformationPayer,
			BillingInformation billingInformationReceiver, LocalDate datePerformPayement) {
		this.id = id;
		this.receiverUserId = receiverUserId;
		this.payment = payment;
		this.billingInformationPayer = billingInformationPayer;
		this.billingInformationReceiver = billingInformationReceiver;
		this.datePerformPayement = datePerformPayement;
	}

	public static ScheduledPayment of(Id id, Id receiverUserId, Payment payment, BillingInformation billingInformationPayer, BillingInformation billingInformationReceiver, LocalDate datePerformPayement){
        return new ScheduledPayment(id, receiverUserId, payment, billingInformationPayer, billingInformationReceiver, datePerformPayement);
    }

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public BillingInformation getBillingInformationPayer() {
		return billingInformationPayer;
	}

	public void setBillingInformationPayer(BillingInformation billingInformationPayer) {
		this.billingInformationPayer = billingInformationPayer;
	}

	public BillingInformation getBillingInformationReceiver() {
		return billingInformationReceiver;
	}

	public void setBillingInformationReceiver(BillingInformation billingInformationReceiver) {
		this.billingInformationReceiver = billingInformationReceiver;
	}

	public LocalDate getDatePerformPayement() {
		return datePerformPayement;
	}

	public void setDatePerformPayement(LocalDate datePerformPayement) {
		this.datePerformPayement = datePerformPayement;
	}

	public Id getId() {
		return id;
	}

	public Id getReceiverUserId() {
		return receiverUserId;
	}

	@Override
	public String toString() {
		return "ScheduledPayment [id=" + id + ", receiverUserId=" + receiverUserId + ", payment=" + payment
				+ ", billingInformationPayer=" + billingInformationPayer + ", billingInformationReceiver="
				+ billingInformationReceiver + ", localDate=" + datePerformPayement + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billingInformationPayer == null) ? 0 : billingInformationPayer.hashCode());
		result = prime * result + ((billingInformationReceiver == null) ? 0 : billingInformationReceiver.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((datePerformPayement == null) ? 0 : datePerformPayement.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((receiverUserId == null) ? 0 : receiverUserId.hashCode());
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
		ScheduledPayment other = (ScheduledPayment) obj;
		if (billingInformationPayer == null) {
			if (other.billingInformationPayer != null)
				return false;
		} else if (!billingInformationPayer.equals(other.billingInformationPayer))
			return false;
		if (billingInformationReceiver == null) {
			if (other.billingInformationReceiver != null)
				return false;
		} else if (!billingInformationReceiver.equals(other.billingInformationReceiver))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (datePerformPayement == null) {
			if (other.datePerformPayement != null)
				return false;
		} else if (!datePerformPayement.equals(other.datePerformPayement))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (receiverUserId == null) {
			if (other.receiverUserId != null)
				return false;
		} else if (!receiverUserId.equals(other.receiverUserId))
			return false;
		return true;
	}
}
