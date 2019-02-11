package br.com.lepsistemas.aicurriculumvitae.usecase;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@Service
public class ResumeService implements ApiService {

	private PersonalInfoService personalInfoService;
	private LanguagesService languagesService;
	private SkillsService skillsService;
	private ProfessionalService professionalService;
	
	public ResumeService(PersonalInfoService personalInfoService, SkillsService skillsService, LanguagesService languagesService, ProfessionalService professionalService) {
		this.personalInfoService = personalInfoService;
		this.skillsService = skillsService;
		this.languagesService = languagesService;
		this.professionalService = professionalService;
	}
	
	public Domain fetch() {
		Resume resume = new Resume();
		resume.setPersonalInfo(personalInfoService.fetch());
		resume.setSkills(skillsService.fetch());
		resume.setLanguages(languagesService.fetch());
		resume.setProfessional(professionalService.fetch());
		return resume;
	}

}
