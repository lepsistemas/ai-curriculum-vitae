package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.exception.InvalidActionException;

public class CurriculumServiceFactoryTest {
	
	private CurriculumServiceFactory factory;
	private ResumeService resumeService;
	private PersonalInfoService personalInfoService;
	private ProfessionalGoalService professionalGoalService;
	
	@Before
	public void initialize() {
		professionalGoalService = new ProfessionalGoalService();
		personalInfoService = new PersonalInfoService();
		resumeService = new ResumeService(personalInfoService);
		factory = new CurriculumServiceFactory(resumeService, personalInfoService, professionalGoalService);
	}
	
	@Test
	public void should_make_resume_service() {
		ApiService apiService = factory.get(RequestDto.ALL);
		
		assertThat(apiService, Matchers.sameInstance(resumeService));
	}
	
	@Test
	public void should_make_personal_info_service() {
		ApiService apiService = factory.get(RequestDto.PERSONAL_INFO);
		
		assertThat(apiService, Matchers.sameInstance(personalInfoService));
	}
	
	@Test
	public void should_make_professional_goal_service() {
		ApiService apiService = factory.get(RequestDto.PROFESSIONAL_GOAL);
		
		assertThat(apiService, Matchers.sameInstance(professionalGoalService));
	}
	
	@Test(expected = InvalidActionException.class)
	public void should_throw_invalid_action() {
		factory.get("XXX");
	}

}
