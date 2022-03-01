package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import ecommercGesture.exposition.projectDTO.WorkerDTO;
import kernel.Command;

@SuppressWarnings("all")
public class RemoveProjectWorker implements Command {
	
	public final int projectId;
	public final WorkerDTO workerDTO;
	
	public RemoveProjectWorker(int projectId, WorkerDTO workerDTO) {
		this.projectId = projectId;
		this.workerDTO = workerDTO;
	}
}