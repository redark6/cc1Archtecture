package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import java.util.stream.Collectors;

import ecommercGesture.application.projectQueriesCommandsEvent.events.AddProjectWorkerEvent;
import ecommercGesture.application.projectQueriesCommandsEvent.events.CloseProjectEvent;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.services.ProjectCreationModificationService;
import ecommercGesture.exposition.projectDTO.LocationDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;

public class CloseProjectCommandeHandler implements CommandHandler<CloseProject, ProjectDTO>{
	
    private final ProjectCreationModificationService creationModificationService;
    private final EventDispatcher<Event> eventDispatcher;
    
    public CloseProjectCommandeHandler(ProjectCreationModificationService creationModificationService, EventDispatcher<Event> eventDispatcher) {
        this.creationModificationService = creationModificationService;
    	this.eventDispatcher = eventDispatcher;
    }
    
    public ProjectDTO handle(CloseProject command) {
    	Project project = creationModificationService.closeProject(Id.of(command.projectId));
    	eventDispatcher.dispatch(CloseProjectEvent.of(project.getId()));
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
