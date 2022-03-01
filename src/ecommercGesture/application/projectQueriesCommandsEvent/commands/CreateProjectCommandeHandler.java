package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ecommercGesture.application.projectQueriesCommandsEvent.events.AddProjectWorkerEvent;
import ecommercGesture.domain.enums.Jobs;
import ecommercGesture.domain.enums.Skills;
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

public class CreateProjectCommandeHandler implements CommandHandler<CreateProject, ProjectDTO>{

    private final ProjectCreationModificationService ProjectCreationModificationService;
    private final ProjectService projectService;
    private final EventDispatcher<Event> eventDispatcher;
    
    public CreateProjectCommandeHandler(
			ecommercGesture.domain.services.ProjectCreationModificationService projectCreationModificationService,
			ProjectService projectService, EventDispatcher<Event> eventDispatcher) {
		ProjectCreationModificationService = projectCreationModificationService;
		this.projectService = projectService;
		this.eventDispatcher = eventDispatcher;
	}

	public ProjectDTO handle(CreateProject command) {
    	final Id projectId = projectService.getNextId();
		List<Id> workers = new ArrayList<Id>();
		List<Jobs> jobs = new ArrayList<Jobs>();
		List<Skills> skills = new ArrayList<Skills>();
    	Project newProject = Project.of(projectId,
    			Id.of(command.createProjectDTO.projectManagerId),
    			LocalDate.now(),
    			command.createProjectDTO.startProjectDate,
    			command.createProjectDTO.projectName,
    			command.createProjectDTO.projectDescrition,
    			command.createProjectDTO.projectPrice,
    			command.createProjectDTO.billRate,
    			Location.of(
    					command.createProjectDTO.location.country,
    					command.createProjectDTO.location.region,
    					command.createProjectDTO.location.city,
    					command.createProjectDTO.location.address),
    			workers,
    			jobs,
    			skills,
    			command.createProjectDTO.duration,
    			null);
    	
    	Project project = ProjectCreationModificationService.createProject(
    			newProject,
    			command.createProjectDTO.requiredJobs,
    			command.createProjectDTO.skills
    			);
    	
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