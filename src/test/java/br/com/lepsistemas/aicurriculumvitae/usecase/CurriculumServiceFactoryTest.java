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
	private SkillsService skillsService;
	private LanguagesService languagesService;
	private ProfessionalService professionalService;
	
	@Before
	public void initialize() {
		resumeService = new ResumeService(personalInfoService, skillsService, languagesService, professionalService);
		personalInfoService = new PersonalInfoService();
		skillsService = new SkillsService();
		languagesService = new LanguagesService();
		professionalService = new ProfessionalService();
		factory = new CurriculumServiceFactory(resumeService, personalInfoService, skillsService, languagesService, professionalService);
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
		ApiService apiService = factory.get(RequestDto.SKILLS);
		
		assertThat(apiService, Matchers.sameInstance(skillsService));
	}
	
	@Test(expected = InvalidActionException.class)
	public void should_throw_invalid_action() {
		factory.get("XXX");
	}

}
