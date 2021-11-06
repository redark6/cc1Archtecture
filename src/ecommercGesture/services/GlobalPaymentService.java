package ecommercGesture.services;

import ecommercGesture.additionalClass.BillingInformation;
import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.externalServices.ExternalPaymentService;

public class GlobalPaymentService {
	
	private final PaymentService paymentService;
	private final ExternalPaymentService externalPaymentService;
	
	public GlobalPaymentService(PaymentService paymentService, ExternalPaymentService externalPaymentService) {
		this.paymentService = paymentService;
		this.externalPaymentService = externalPaymentService;
	}

	public PaymentEntity getPayment(int id) {
		return paymentService.getPayment(id);
	}
	
	public void addPayment(PaymentEntity payment) {
		paymentService.addPayment(payment);
	}
	
	public boolean pay(BillingInformation billing, double transactionPrice) {
		return externalPaymentService.proceedToPayment(billing,transactionPrice);
	}
}
