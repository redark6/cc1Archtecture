package ecommercGesture.application.memberQueriesCommandsEvents.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class AddScheduledPaymentEvent implements ApplicationEvent {
	
	public final Id scheduledPaymentId;
	
    public static AddScheduledPaymentEvent of(Id id) {
        return new AddScheduledPaymentEvent(id);
    }
	
	private AddScheduledPaymentEvent(Id scheduledPaymentId) {
		this.scheduledPaymentId = scheduledPaymentId;
	}
}
