package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import ecommercGesture.exposition.projectDTO.ModifyProjectDTO;
import kernel.Command;

@SuppressWarnings("all")
public class ModifyProject implements Command {
	
	public final int projectId;
	public final ModifyProjectDTO modifyProjectDTO;
	
	public ModifyProject(int projectId,ModifyProjectDTO modifyProjectDTO) {
		this.projectId = projectId;
		this.modifyProjectDTO = modifyProjectDTO;
	}
}
