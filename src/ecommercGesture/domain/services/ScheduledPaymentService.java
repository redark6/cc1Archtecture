package ecommercGesture.domain.services;

import java.util.List;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.domain.repositories.ScheduledPaymentRepository;

public class ScheduledPaymentService {

	private final ScheduledPaymentRepository scheduledPaymentRepository;

	public ScheduledPaymentService(ScheduledPaymentRepository scheduledPaymentRepository) {
		this.scheduledPaymentRepository = scheduledPaymentRepository;
	}
	
	public Id getNextId() {
		return scheduledPaymentRepository.getNextId();
	}
	
	public ScheduledPayment getScheduledPaymentById(Id id) {
		return scheduledPaymentRepository.getScheduledPaymentById(id);
	}
	
	public List<ScheduledPayment> getAll() {
		return scheduledPaymentRepository.getAll();
	}
	
	public ScheduledPayment saveScheduledPayment(ScheduledPayment scheduledPayment) {
		return scheduledPaymentRepository.saveScheduledPayment(scheduledPayment);
	}
	
	public void removeScheduledPaymentById(Id id) {
		scheduledPaymentRepository.removeScheduledPaymentById(id);
	}
	
}
