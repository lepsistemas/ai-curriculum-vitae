package br.com.lepsistemas.aicurriculumvitae.domain;

public class Resume implements Domain {

	private PersonalInfo personalInfo;
	private Languages languages;
	private Skills skills;
	private Professional professional;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Languages getLanguages() {
		return languages;
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	@Override
	public String toString() {
		return "Leandro's curriculum is vast. I think you'll get tired of listening entirely.";
	}

}
