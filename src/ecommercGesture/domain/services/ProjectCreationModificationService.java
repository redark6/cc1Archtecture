package ecommercGesture.domain.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ecommercGesture.domain.enums.Jobs;
import ecommercGesture.domain.enums.ProjectStates;
import ecommercGesture.domain.enums.Skills;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.infrastructure.exception.InvalidProjectBillRateException;
import ecommercGesture.infrastructure.exception.InvalidProjectPriceException;
import ecommercGesture.infrastructure.exception.InvalideDurationException;
import ecommercGesture.infrastructure.exception.UnknownJobsException;
import ecommercGesture.infrastructure.exception.UnknownSkillsException;
import ecommercGesture.infrastructure.exception.UserAlreadyWorkOnProjectException;
import ecommercGesture.infrastructure.exception.UserNotMemberException;
import ecommercGesture.infrastructure.exception.UserNotWorkOnProjectException;
import ecommercGesture.infrastructure.exception.UserNotfoundException;

public class ProjectCreationModificationService {

	private final UserService userService;
	private final MembershipService membershipService;
	private final ProjectService projectService;
	
	public ProjectCreationModificationService(UserService userService, MembershipService membershipService,ProjectService projectService) {
		this.userService = userService;
		this.membershipService = membershipService;
		this.projectService = projectService;
	}
	
	public Project createProject(Project project, List<String> jobs, List<String> skills) {
		if(!userExist(project.getProjectManagerId())) {
			throw UserNotfoundException.withId(project.getProjectManagerId());
		}
		checkUserMembership(project.getProjectManagerId());
		return this.modifyProject(project, jobs, skills);
	}
	
	public Project modifyProject(Project project, List<String> jobs, List<String> skills) {
		project.setRequiredJobs(getJobsList(jobs));
		project.setSkills(getSkillsList(skills));
		checkDuration(project.getDuration());
		checkPrice(project.getProjectPrice());
		checkBillRate(project.getBillRate());
		project.setState(getProjectState(project.getStartProjectDate(),project.getDuration()));
		return this.projectService.saveProject(project);
	}
	
	private ProjectStates getProjectState(LocalDate startProjectDate,int duration) {
		LocalDate today = LocalDate.now();
		if(startProjectDate.isAfter(today)) {
			return ProjectStates.AWAITING_START;
		}else if(startProjectDate.isBefore(today) && startProjectDate.plusDays(duration).isAfter(today)) {
			return ProjectStates.IN_PROGRESS;
		}else {
			return ProjectStates.FINISHED;
		}
	}

	private void checkUserMembership(Id userId) {
		if(!this.membershipService.isCurrentlyMember(userId)) {
			throw UserNotMemberException.withId(userId);
		}
	}
	
	private boolean userExist(Id userId) {
		return this.userService.userExist(userId);
	}
	
	private void checkDuration(int duration) {
		if(duration < 1) {
			throw InvalideDurationException.withDuration(duration);
		}
	}
	
	private void checkPrice(double price) {
		if(price < 0) {
			throw InvalidProjectPriceException.withPrice(price);
		}
	}
	
	private void checkBillRate(double billRate) {
		if(billRate < 0) {
			throw InvalidProjectBillRateException.withBillRate(billRate);
		}
	}
	
	private List<Jobs> getJobsList(List<String> jobs) {
		List<String> unknowJobs = new ArrayList<String>();
		List<Jobs> result = new ArrayList<Jobs>();
		boolean found;
		
		for(String job: jobs) {
			found = false;
			for(Jobs existingJob: Jobs.values()) {
				if(job.equals(existingJob.getJobName())) {
					result.add(existingJob);
					found = true;
				}
			}
			if(!found) {
				unknowJobs.add(job);
			}
		}
		if(unknowJobs.size() == 0) {
			return result;
		}else {
			throw UnknownJobsException.withJobs(unknowJobs);
		}
	}
	
	private List<Skills> getSkillsList(List<String> skills) {
		List<String> unknowSkills = new ArrayList<String>();
		List<Skills> result = new ArrayList<Skills>();
		boolean found;
		
		for(String skill: skills) {
			found = false;
			for(Skills existingSkills: Skills.values()) {
				if(skill.equals(existingSkills.getSkillName())) {
					result.add(existingSkills);
					found = true;
				}
			}
			if(!found) {
				unknowSkills.add(skill);
			}
		}
		if(unknowSkills.size() == 0) {
			return result;
		}else {
			throw UnknownSkillsException.withJobs(unknowSkills);
		}
	}
	
	public Project addWorkerToProject(Id id, Id workerId) {
		Project project = this.projectService.getProjectById(id);
		List<Id> workers = project.getWorkerIds();
		if(!workerAlreadyWorkInProject(workers, workerId)) {
			workers.add(workerId);
			project.setWorkerIds(workers);
			return this.projectService.saveProject(project);
		}else {
			throw UserAlreadyWorkOnProjectException.withId(workerId);
		}
	}
	
	public Project removeWorkerFromeProject(Id id, Id workerId) {
		Project project = this.projectService.getProjectById(id);
		List<Id> workers = project.getWorkerIds();
		if(workerAlreadyWorkInProject(workers, workerId)) {
			workers.remove(workerId);
			project.setWorkerIds(workers);
			return this.projectService.saveProject(project);
		}else {
			throw UserNotWorkOnProjectException.withId(workerId);
		}
	}
	
	private boolean workerAlreadyWorkInProject(List<Id> projectWorkers, Id workerId) {
		if(userExist(workerId)) {
			checkUserMembership(workerId);
			int workerIdInt = workerId.getId();
			for(Id worker : projectWorkers) {
			   	if(worker.getId() == workerIdInt) {
			   		return true;
			   	}
			}
			return false;
		}else {
			throw UserNotfoundException.withId(workerId);
		}
	}

}
