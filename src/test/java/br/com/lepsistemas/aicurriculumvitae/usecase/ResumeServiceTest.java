package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

public class ResumeServiceTest {
	
	private ResumeService resumeService;
	
	private PersonalInfoService personalInfoService;

	@Before
	public void initialize() {
		personalInfoService = new PersonalInfoService();
		resumeService = new ResumeService(personalInfoService);
	}
	
	@Test
	public void should_fetch_resume() throws Exception {
		Resume resume = (Resume) resumeService.fetch();
		
		assertThat(resume.getPersonalInfo(), is(personalInfoService.fetch()));
	}

}
