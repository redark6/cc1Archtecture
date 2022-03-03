package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import ecommercGesture.exposition.projectDTO.WorkerDTO;
import kernel.Command;

@SuppressWarnings("all")
public class CloseProject implements Command {
	
	public final int projectId;
	
	public CloseProject(int projectId) {
		this.projectId = projectId;
	}

}
