package br.com.lepsistemas.aicurriculumvitae.domain;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SkillsTest {

	@Test
	public void should_convert_to_string() throws Exception {
		Skills professionalGoal = new Skills(
				asList("Java", "JavaScript"),
				asList("PostgreSQL", "MongoDB"),
				asList("Docker", "Git"));
		
		assertThat(professionalGoal.toString(), equalTo("Leandro has knowledge in many languages and technologies. His programming skills include Java, JavaScript. Regarding databases, he has worked with these: PostgreSQL, MongoDB. The technologies he uses are Docker, Git."));
	}
	
}
