package ecommercGesture.application.memberQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveScheduledPaymentById implements Query{

	public final int scheduledPaymentId;
	
    public RetrieveScheduledPaymentById(int scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }
}
