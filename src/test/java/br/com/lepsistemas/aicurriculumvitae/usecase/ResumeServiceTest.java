package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

public class ResumeServiceTest {
	
	private ResumeService resumeService;
	
	private PersonalInfoService personalInfoService;

	private LanguagesService languagesService;

	private SkillsService skillsService;

	private ProfessionalService professionalService;

	@Before
	public void initialize() {
		personalInfoService = new PersonalInfoService();
		languagesService = new LanguagesService();
		skillsService = new SkillsService();
		professionalService = new ProfessionalService();
		resumeService = new ResumeService(personalInfoService, skillsService, languagesService, professionalService);
	}
	
	@Test
	public void should_fetch_resume() throws Exception {
		Resume resume = (Resume) resumeService.fetch();
		
		assertThat(resume.getPersonalInfo().toString(), is(personalInfoService.fetch().toString()));
		assertThat(resume.getSkills().toString(), is(skillsService.fetch().toString()));
		assertThat(resume.getLanguages().toString(), is(languagesService.fetch().toString()));
		assertThat(resume.getProfessional().toString(), is(professionalService.fetch().toString()));
	}

}
