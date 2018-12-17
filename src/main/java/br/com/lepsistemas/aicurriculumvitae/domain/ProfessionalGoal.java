package br.com.lepsistemas.aicurriculumvitae.domain;

public class ProfessionalGoal implements Domain {

	private String goal;

	public ProfessionalGoal(String goal) {
		this.goal = goal;
	}

	public String getGoal() {
		return goal;
	}
	
	@Override
	public String toString() {
		return "His professional goal is to be a " + goal + ". For the backend Leandro can work with Spring Boot and for the frontend, it's your call. Do you prefer Angular2+ or ReactJs? He can create components with both.";
	}

}
