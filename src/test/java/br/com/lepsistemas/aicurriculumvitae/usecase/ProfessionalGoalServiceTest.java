package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.ProfessionalGoal;

public class ProfessionalGoalServiceTest {
	
	private ProfessionalGoalService service;
	
	@Before
	public void initialize() {
		service = new ProfessionalGoalService();
	}
	
	@Test
	public void should_fetch_personal_info() throws ParseException {
		ProfessionalGoal professionalGoal = service.fetch();
		
		assertThat(professionalGoal.getGoal(), is("Java Full Stack Developer"));
	}

}
