package ecommercGesture.domain.enums;

public enum WorkerStates {
	OPEN_TO_WORK("Open to work"),BUSY("Busy");
	
	private String state;
	
	private WorkerStates(String state) {
		this.state = state;
	}
	
	public String GetState() {
		return this.state;
	}
}
