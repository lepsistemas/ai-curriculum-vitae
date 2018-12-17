package br.com.lepsistemas.aicurriculumvitae.delivery;

import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

public class ResumeDto implements ApiResponse {
	
	private PersonalInfoDto personalInfo;
	
	public ResumeDto(Resume resume) {
		this.personalInfo = new PersonalInfoDto(resume.getPersonalInfo());
	}

	public PersonalInfoDto getPersonalInfo() {
		return personalInfo;
	}

}
