package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import ecommercGesture.exposition.projectDTO.CreateProjectDTO;
import kernel.Command;

@SuppressWarnings("all")
public class CreateProject  implements Command{
	public final CreateProjectDTO createProjectDTO;
	
	public CreateProject(CreateProjectDTO createProjectDTO) {
		this.createProjectDTO = createProjectDTO;
	}
}
