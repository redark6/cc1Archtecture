package ecommercGesture.application.projectQueriesCommandsEvent.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class CreateProjectEvent implements ApplicationEvent{

	public final Id projectId;
	
    public static CreateProjectEvent of(Id id) {
        return new CreateProjectEvent(id);
    }
	
	private CreateProjectEvent(Id projectId) {
		this.projectId = projectId;
	}
}
