package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import java.util.stream.Collectors;

import ecommercGesture.application.projectQueriesCommandsEvent.events.AddProjectWorkerEvent;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Location;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.services.ProjectCreationModificationService;
import ecommercGesture.domain.services.ProjectService;
import ecommercGesture.exposition.projectDTO.LocationDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;

public class ModifyProjectCommandHandler implements CommandHandler<ModifyProject, ProjectDTO>{

    private final ProjectCreationModificationService ProjectCreationModificationService;
    private final ProjectService projectService;
    private final EventDispatcher<Event> eventDispatcher;
    
    public ModifyProjectCommandHandler(
			ecommercGesture.domain.services.ProjectCreationModificationService projectCreationModificationService,
			ProjectService projectService, EventDispatcher<Event> eventDispatcher) {
		ProjectCreationModificationService = projectCreationModificationService;
		this.projectService = projectService;
		this.eventDispatcher = eventDispatcher;
	}
    
    public ProjectDTO handle(ModifyProject command) {
    	Project project = projectService.getProjectById(Id.of(command.projectId));
    	
    	project.setStartProjectDate(command.modifyProjectDTO.startProjectDate);
    	project.setProjectName(command.modifyProjectDTO.projectName);
    	project.setProjectDescrition(command.modifyProjectDTO.projectDescrition);
    	project.setProjectPrice(command.modifyProjectDTO.projectPrice);
    	project.setBillRate(command.modifyProjectDTO.billRate);
    	project.setLocation(
    			Location.of(
    					command.modifyProjectDTO.location.country,
    					command.modifyProjectDTO.location.region,
    					command.modifyProjectDTO.location.city,
    					command.modifyProjectDTO.location.address)
    			);
    	project.setDuration(command.modifyProjectDTO.duration);
    	
    	project = ProjectCreationModificationService.modifyProject(project, command.modifyProjectDTO.requiredJobs, command.modifyProjectDTO.skills);
    	eventDispatcher.dispatch(AddProjectWorkerEvent.of(project.getId()));
    	
    	ProjectDTO projectResponseResult = ProjectDTO.of(project.getId().getId(),
    			project.getProjectManagerId().getId(),
    			project.getCreationDate(),
    			project.getStartProjectDate(),
    			project.getProjectName(),
    			project.getProjectDescrition(), project.getProjectPrice(),
    			project.getBillRate(),
    			LocationDTO.of(
    					project.getLocation().getCountry(),
    					project.getLocation().getRegion(),
    					project.getLocation().getCity(),
    					project.getLocation().getAddress()),
    			project.getWorkerIds().stream().map(workerId -> workerId.getId()).collect(Collectors.toList()),
    			project.getRequiredJobs().stream().map(job -> job.getJobName()).collect(Collectors.toList()),
    			project.getSkills().stream().map(skill -> skill.getSkillName()).collect(Collectors.toList()),
    			project.getDuration(),
    			project.getState().name());
    	return projectResponseResult;
    }
}