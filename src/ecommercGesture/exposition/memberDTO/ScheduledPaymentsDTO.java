package ecommercGesture.exposition.memberDTO;

import java.util.List;

@SuppressWarnings("all")
public class ScheduledPaymentsDTO {

	public final List<ScheduledPaymentDTO> scheduledPayments;
	
    public static ScheduledPaymentsDTO of(List<ScheduledPaymentDTO> scheduledPayments) {
    	return new ScheduledPaymentsDTO(scheduledPayments);
    }

    private ScheduledPaymentsDTO(List<ScheduledPaymentDTO> scheduledPayments) {
        this.scheduledPayments = scheduledPayments;
    }
}
