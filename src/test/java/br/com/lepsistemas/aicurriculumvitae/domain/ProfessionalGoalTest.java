package br.com.lepsistemas.aicurriculumvitae.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProfessionalGoalTest {

	@Test
	public void should_convert_to_string() throws Exception {
		ProfessionalGoal professionalGoal = new ProfessionalGoal("Java Full Stack Developer");
		
		assertThat(professionalGoal.toString(), equalTo("His professional goal is to be a Java Full Stack Developer. For the backend Leandro can work with Spring Boot and for the frontend, it's your call. Do you prefer Angular2+ or ReactJs? He can create components with both."));
	}
	
}
