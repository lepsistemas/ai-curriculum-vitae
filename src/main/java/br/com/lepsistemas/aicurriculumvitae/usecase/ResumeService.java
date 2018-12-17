package br.com.lepsistemas.aicurriculumvitae.usecase;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@Service
public class ResumeService implements ApiService {

	private PersonalInfoService personalInfoService;
	
	public ResumeService(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}
	
	public Domain fetch() {
		Resume resume = new Resume();
		resume.setPersonalInfo(personalInfoService.fetch());
		return resume;
	}

}
