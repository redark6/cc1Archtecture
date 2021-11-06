package ecommercGesture.services;

import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.repositories.PaymentRepository;

public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentEntity getPayment(int id) {
		return paymentRepository.getPayment(id).get();
	}
	
	public void addPayment(PaymentEntity payment) {
		paymentRepository.addPayment(payment);
	}

}
