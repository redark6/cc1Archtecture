package ecommercGesture.domain.enums;

public enum Skills {
	ACCOUNTING("Accounting"), DATA_ANALYSIS("Data analysis"), DATA_PRIVACY("Data privacy"),
	ENTREPRISE_RESSOURCE_PLANNING("Enterprise resource planning"),HUMAN_RESSOURCES("Human resources"),
	MATHEMATICS("Mathematics"),MULTILINGUALISM("Multilingualism"), PROCESS_AUTOMATION("Process automation"),
	PRODUCT_DESIGN("Product design"), PROJECT_MANAGEMENT("Project management"),RESEARCH_SKILLS("Research skills"),
	SOFTWARE_PROFICIENCY("Software proficiency"), SEARCH_ENGINE_OPTIMIZATION("Search engine optimization"),
	TYPING_SKILLS("Typing skills"), WRITING_AND_EDITING("Writing and editing");
	
	private String skillName;
	
	private Skills(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillName() {
		return this.skillName;
	}
}
