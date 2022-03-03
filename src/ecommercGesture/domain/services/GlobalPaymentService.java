package ecommercGesture.domain.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import ecommercGesture.domain.objects.BillingInformation;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Payment;
import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.infrastructure.exception.PaymentErrorException;


public class GlobalPaymentService {
	
	private final PaymentService paymentService;
	private final ExternalPaymentService externalPaymentService;
	private final ScheduledPaymentService scheduledPaymentService;
	
	
	public GlobalPaymentService(PaymentService paymentService, ExternalPaymentService externalPaymentService, ScheduledPaymentService scheduledPaymentService) {
		this.paymentService = paymentService;
		this.externalPaymentService = externalPaymentService;
		this.scheduledPaymentService = scheduledPaymentService;
	}
	
	public Id getNextId() {
		return paymentService.getNextId();
	}
	
	public Payment getPayment(Id id) {
		return paymentService.getPaymentById(id);
	}
	
	public Payment addPayment(Payment payment) {
		return paymentService.addPayment(payment);
	}
	
	public boolean pay(BillingInformation billing, double transactionPrice) {
		return externalPaymentService.proceedToPayment(billing,transactionPrice);
	}
	
	public Id getNextScheduledPaymentId() {
		return scheduledPaymentService.getNextId();
	}

	public ScheduledPayment addScheduledPayment(ScheduledPayment scheduledPayment) {
		return scheduledPaymentService.saveScheduledPayment(scheduledPayment);
	}

	@Scheduled(cron = "0 0 12 * * ?")
	private void generatePayments(){
		List<ScheduledPayment> scheduledPayments = this.scheduledPaymentService.getAll();
		scheduledPayments.forEach(schedulePayment -> {

			if(LocalDate.now().isAfter(schedulePayment.getDatePerformPayement()) || LocalDate.now().isEqual(schedulePayment.getDatePerformPayement())){
				if(externalPaymentService.proceedToScheduledPayment(
						schedulePayment.getBillingInformationPayer(),
						schedulePayment.getBillingInformationReceiver(),
						schedulePayment.getPayment().getTransactionPrice()
					)
				){
					this.addPayment(schedulePayment.getPayment());
					this.scheduledPaymentService.removeScheduledPaymentById(schedulePayment.getId());
				}else {
					throw PaymentErrorException.error();
				}
			}
		});	
	}
}
