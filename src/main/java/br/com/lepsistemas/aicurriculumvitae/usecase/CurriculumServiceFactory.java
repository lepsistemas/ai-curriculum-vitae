package br.com.lepsistemas.aicurriculumvitae.usecase;

import java.util.HashMap;
import java.util.Map;

import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.exception.InvalidActionException;

public class CurriculumServiceFactory {
	
	private final Map<String, ApiService> servicesByAction = new HashMap<>();
	
	public CurriculumServiceFactory(ResumeService resumeService, PersonalInfoService personalInfoService, SkillsService skillsService, LanguagesService languagesService, ProfessionalService professionalExperiencesService) {
		servicesByAction.put(RequestDto.ALL, resumeService);
		servicesByAction.put(RequestDto.PERSONAL_INFO, personalInfoService);
		servicesByAction.put(RequestDto.SKILLS, skillsService);
		servicesByAction.put(RequestDto.LANGUAGES, languagesService);
		servicesByAction.put(RequestDto.PROFESSIONAL_EXPERIENCES, professionalExperiencesService);
	}

	public ApiService get(String action) {
		ApiService apiService = servicesByAction.get(action);
		if (apiService == null) {
			throw new InvalidActionException("Invalid action");
		}
		return apiService;
	}

}
