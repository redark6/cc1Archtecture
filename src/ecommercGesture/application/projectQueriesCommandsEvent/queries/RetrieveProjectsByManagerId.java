package ecommercGesture.application.projectQueriesCommandsEvent.queries;

import kernel.Query;

public class RetrieveProjectsByManagerId implements Query{
	public final int managerId;
	
    public RetrieveProjectsByManagerId(int managerId) {
        this.managerId = managerId;
    }
}
