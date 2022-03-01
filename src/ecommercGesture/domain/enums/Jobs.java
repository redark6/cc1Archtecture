package ecommercGesture.domain.enums;

public enum Jobs {
	
	PHYSICIAN("Physician"),WEB_DEVELOPER("Web developer"),INTERPRETER("Interpreter "),
	MECHANICAL_ENGINEER("Mechanical engineer"), EPIDEMIOLOGIST("Epidemiologist"),
	MEDICAL_SECRETARY("Medical secretary"), LAWYER("Lawyer"), FINANCIAL_MANAGER("Financial manager"),
	HAIRDRESSER("Hairdresser"),FINANCIAL_ANALYST("Financial analyst"), ARCHITECT("Architect"),
	PLUMBER("Plumber"), LOGISTICIAN("Logistician"), RECEPTIONIST("Receptionist"),
	SPORT_COACH("Sports coach"), CASHIER("Cashier");
	
	
	private String jobName;
	
	private Jobs(String jobName) {
		this.jobName = jobName;
	}
	
	public String getJobName() {
		return this.jobName;
	}

}