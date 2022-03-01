package ecommercGesture.application.projectQueriesCommandsEvent.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class RemoveProjectWorkerEvent implements ApplicationEvent{

	public final Id workerId;
	
    public static RemoveProjectWorkerEvent of(Id id) {
        return new RemoveProjectWorkerEvent(id);
    }
	
	private RemoveProjectWorkerEvent(Id workerId) {
		this.workerId = workerId;
	}
}
