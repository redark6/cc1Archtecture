package ecommercGesture.defaultRepositoryImplementation;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.repositories.PaymentRepository;

public class InMemoryPaymentRepository implements PaymentRepository {
	
	private final AtomicInteger count = new AtomicInteger(0);
	private final Map<Integer, PaymentEntity> data = new ConcurrentHashMap<>();
	
	@Override
	public int getNextId() {
		return count.incrementAndGet();
	}
	
	@Override
	public Optional<PaymentEntity> getPayment(int id){
		return Optional.of(data.get(id));
	}
	
	@Override
	public int addPayment(PaymentEntity payment) {
		data.put(payment.getId(), payment);
		return payment.getId();
	}
}