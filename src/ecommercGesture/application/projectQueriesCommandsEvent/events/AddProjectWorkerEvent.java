package ecommercGesture.application.projectQueriesCommandsEvent.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class AddProjectWorkerEvent implements ApplicationEvent{

	public final Id workerId;
	
    public static AddProjectWorkerEvent of(Id id) {
        return new AddProjectWorkerEvent(id);
    }
	
	private AddProjectWorkerEvent(Id workerId) {
		this.workerId = workerId;
	}
}
