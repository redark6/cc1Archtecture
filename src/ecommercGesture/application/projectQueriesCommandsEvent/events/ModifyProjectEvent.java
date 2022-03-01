package ecommercGesture.application.projectQueriesCommandsEvent.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class ModifyProjectEvent implements ApplicationEvent{

	public final Id projectId;
	
    public static ModifyProjectEvent of(Id id) {
        return new ModifyProjectEvent(id);
    }
	
	private ModifyProjectEvent(Id projectId) {
		this.projectId = projectId;
	}
}
