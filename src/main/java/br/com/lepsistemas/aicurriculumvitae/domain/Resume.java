package br.com.lepsistemas.aicurriculumvitae.domain;

public class Resume implements Domain {
	
	private PersonalInfo personalInfo;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	@Override
	public String toString() {
		return "Leandro's curriculum is vast. I think you'll get tired of listening entirely. Please, tap on the right button and I'll take you to his Curriculum Vitae page. From there, you'll be able to send it to your e-mail.";
	}

}
