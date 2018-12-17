package br.com.lepsistemas.aicurriculumvitae.delivery;

import java.util.HashMap;
import java.util.Map;

import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.ApiService;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalGoalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.exceptions.InvalidActionException;

public class CurriculumServiceFactory {
	
	private final Map<String, ApiService> servicesByAction = new HashMap<>();
	
	public CurriculumServiceFactory(ResumeService resumeService, PersonalInfoService personalInfoService, ProfessionalGoalService professionalGoalService) {
		servicesByAction.put(RequestDto.ALL, resumeService);
		servicesByAction.put(RequestDto.PERSONAL_INFO, personalInfoService);
		servicesByAction.put(RequestDto.PROFESSIONAL_GOAL, professionalGoalService);
	}

	public ApiService get(String action) {
		ApiService apiService = servicesByAction.get(action);
		if (apiService == null) {
			throw new InvalidActionException("Invalid action");
		}
		return apiService;
	}

}
