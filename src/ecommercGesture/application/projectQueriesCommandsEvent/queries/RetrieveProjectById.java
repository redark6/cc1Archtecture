package ecommercGesture.application.projectQueriesCommandsEvent.queries;

import kernel.Query;

public class RetrieveProjectById implements Query {
	public final int projectId;
	
    public RetrieveProjectById(int projectId) {
        this.projectId = projectId;
    }

}
