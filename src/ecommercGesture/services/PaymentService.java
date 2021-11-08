package ecommercGesture.services;

import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.repositories.PaymentRepository;

public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	public int getNextId() {
		return paymentRepository.getNextId();
	}
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public PaymentEntity getPayment(int id) {
		return paymentRepository.getPayment(id).get();
	}
	
	public int addPayment(PaymentEntity payment) {
		return paymentRepository.addPayment(payment);
	}

}
