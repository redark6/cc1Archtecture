package ecommercGesture.repositories;

import java.util.Optional;

import ecommercGesture.entities.PaymentEntity;

public interface PaymentRepository {
	
	Optional<PaymentEntity> getPayment(int id);
	void addPayment(PaymentEntity payement);

}
