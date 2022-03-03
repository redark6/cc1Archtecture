package ecommercGesture.infrastructure.defaultRepositoryImplementation;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.domain.repositories.ScheduledPaymentRepository;
import kernel.NoSuchEntityException;

@Repository
public class InMemoryScheduledPaymentRepository implements ScheduledPaymentRepository {
	
	private final AtomicInteger count = new AtomicInteger(0);
	private final Map<Id, ScheduledPayment> data = new ConcurrentHashMap<>();
	
	@Override
    public Id getNextId() {
        return Id.of(count.incrementAndGet());
    }	

	@Override
	public ScheduledPayment getScheduledPaymentById(Id id) {
		ScheduledPayment scheduledPayment = data.get(id);
		if (scheduledPayment == null) {
			throw NoSuchEntityException.withIdAndElem(id,"scheduled payment");
		}
		return scheduledPayment;
	}
	
	@Override
	public List<ScheduledPayment> getAll(){
		List<ScheduledPayment> result = data.values().stream().collect(Collectors.toList());
		return  result;
	}
	
	@Override
	public ScheduledPayment saveScheduledPayment(ScheduledPayment scheduledPayment) {
		data.put(scheduledPayment.getId(), scheduledPayment);
		return scheduledPayment;
	}
	
	@Override
	public void removeScheduledPaymentById(Id id) {
		data.remove(id);
	}
	
}
