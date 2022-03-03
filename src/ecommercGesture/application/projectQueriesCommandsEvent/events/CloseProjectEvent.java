package ecommercGesture.application.projectQueriesCommandsEvent.events;

import ecommercGesture.domain.objects.Id;
import kernel.ApplicationEvent;

public class CloseProjectEvent implements ApplicationEvent{

	public final Id projecId;
	
    public static CloseProjectEvent of(Id id) {
        return new CloseProjectEvent(id);
    }
	
	private CloseProjectEvent(Id projecId) {
		this.projecId = projecId;
	}

}
