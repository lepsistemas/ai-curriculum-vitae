package br.com.lepsistemas.aicurriculumvitae.usecase;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@Service
public class ResumeService implements ApiService {

	private PersonalInfoService personalInfoService;
	private LanguagesService languagesService;
	private SkillsService skillsService;
	
	public ResumeService(PersonalInfoService personalInfoService, SkillsService skillsService, LanguagesService languagesService) {
		this.personalInfoService = personalInfoService;
		this.skillsService = skillsService;
		this.languagesService = languagesService;
	}
	
	public Domain fetch() {
		Resume resume = new Resume();
		resume.setPersonalInfo(personalInfoService.fetch());
		resume.setSkills(skillsService.fetch());
		resume.setLanguages(languagesService.fetch());
		return resume;
	}

}
