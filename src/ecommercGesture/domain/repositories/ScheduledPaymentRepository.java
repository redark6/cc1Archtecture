package ecommercGesture.domain.repositories;

import java.util.List;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.ScheduledPayment;

public interface ScheduledPaymentRepository {

	Id getNextId();
	ScheduledPayment getScheduledPaymentById(Id id);
	List<ScheduledPayment> getAll();
	ScheduledPayment saveScheduledPayment(ScheduledPayment scheduledPayment);
	void removeScheduledPaymentById(Id id);
}
