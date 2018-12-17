package br.com.lepsistemas.aicurriculumvitae.usecase;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.ProfessionalGoal;

@Service
public class ProfessionalGoalService implements ApiService {

	public ProfessionalGoal fetch() {
		return new ProfessionalGoal("Java Full Stack Developer");
	}

}
