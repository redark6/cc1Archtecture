package ecommercGesture.domain.objects;

import java.time.LocalDate;
import java.util.List;

import ecommercGesture.domain.enums.ProjectStates;
import ecommercGesture.domain.enums.Skills;
import ecommercGesture.domain.enums.Jobs;


public class Project {
	
	private final Id id;
	private final Id projectManagerId;
	private final LocalDate creationDate;
	private LocalDate startProjectDate;
	private String projectName;
    private String projectDescrition;
    private double projectPrice;
    private double billRate;
    private Location Location;
    private List<Id> workerIds;
    private List<Jobs> requiredJobs;
    private List<Skills> skills;
    private int duration;
    private ProjectStates state;
    
	public static Project of(Id id, Id projectManagerId, LocalDate creationDate, LocalDate startProjectDate,
			String projectName, String projectDescrition,double projectPrice, double billRate,
			Location location, List<Id> workerIds,
			List<Jobs> requiredJobs, List<Skills> skills, int duration, ProjectStates state) {
		return new Project(id, projectManagerId, creationDate, startProjectDate, projectName, projectDescrition, projectPrice, billRate, location, workerIds, requiredJobs, skills, duration, state);
	}
    
	private Project(Id id, Id projectManagerId, LocalDate creationDate, LocalDate startProjectDate,
			String projectName, String projectDescrition,double projectPrice, double billRate,
			Location location, List<Id> workerIds,
			List<Jobs> requiredJobs, List<Skills> skills, int duration, ProjectStates state) {
		this.id = id;
		this.projectManagerId = projectManagerId;
		this.creationDate = creationDate;
		this.startProjectDate = startProjectDate;
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
		this.projectPrice = projectPrice;
		this.billRate = billRate;
		Location = location;
		this.workerIds = workerIds;
		this.requiredJobs = requiredJobs;
		this.skills = skills;
		this.duration = duration;
		this.state = state;
	}

	public LocalDate getStartProjectDate() {
		return startProjectDate;
	}

	public void setStartProjectDate(LocalDate startProjectDate) {
		this.startProjectDate = startProjectDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescrition() {
		return projectDescrition;
	}

	public void setProjectDescrition(String projectDescrition) {
		this.projectDescrition = projectDescrition;
	}

	public double getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(double projectPrice) {
		this.projectPrice = projectPrice;
	}

	public double getBillRate() {
		return billRate;
	}

	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
	}

	public List<Id> getWorkerIds() {
		return workerIds;
	}

	public void setWorkerIds(List<Id> workerIds) {
		this.workerIds = workerIds;
	}

	public List<Jobs> getRequiredJobs() {
		return requiredJobs;
	}

	public void setRequiredJobs(List<Jobs> requiredJobs) {
		this.requiredJobs = requiredJobs;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ProjectStates getState() {
		return state;
	}

	public void setState(ProjectStates state) {
		this.state = state;
	}

	public Id getId() {
		return id;
	}

	public Id getProjectManagerId() {
		return projectManagerId;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectManagerId=" + projectManagerId + ", projectName=" + projectName
				+ ", projectDescrition=" + projectDescrition + ", projectPrice=" + projectPrice + ", billRate="
				+ billRate + ", Location=" + Location + ", workerIds=" + workerIds + ", requiredJobs=" + requiredJobs
				+ ", skills=" + skills + ", duration=" + duration + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		long temp;
		temp = Double.doubleToLongBits(billRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + duration;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projectDescrition == null) ? 0 : projectDescrition.hashCode());
		result = prime * result + ((projectManagerId == null) ? 0 : projectManagerId.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		temp = Double.doubleToLongBits(projectPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requiredJobs == null) ? 0 : requiredJobs.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((workerIds == null) ? 0 : workerIds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (Double.doubleToLongBits(billRate) != Double.doubleToLongBits(other.billRate))
			return false;
		if (duration != other.duration)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projectDescrition == null) {
			if (other.projectDescrition != null)
				return false;
		} else if (!projectDescrition.equals(other.projectDescrition))
			return false;
		if (projectManagerId == null) {
			if (other.projectManagerId != null)
				return false;
		} else if (!projectManagerId.equals(other.projectManagerId))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (Double.doubleToLongBits(projectPrice) != Double.doubleToLongBits(other.projectPrice))
			return false;
		if (requiredJobs == null) {
			if (other.requiredJobs != null)
				return false;
		} else if (!requiredJobs.equals(other.requiredJobs))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (state != other.state)
			return false;
		if (workerIds == null) {
			if (other.workerIds != null)
				return false;
		} else if (!workerIds.equals(other.workerIds))
			return false;
		return true;
	}

}
