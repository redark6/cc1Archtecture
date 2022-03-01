package ecommercGesture.domain.enums;

public enum ProjectStates {
	AWAITING_START("awaiting start"),IN_PROGRESS("in progress"),FINISHED("finished");
	
	private String state;
	
	private ProjectStates(String state) {
		this.state = state;
	}
	
	public String GetState() {
		return this.state;
	}

}
