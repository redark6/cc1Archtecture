package ecommercGesture.repositories;

import java.util.Optional;

import ecommercGesture.entities.PaymentEntity;

public interface PaymentRepository {
	
	int getNextId();
	Optional<PaymentEntity> getPayment(int id);
	int addPayment(PaymentEntity payment);

}
