package br.com.lepsistemas.aicurriculumvitae.usecase;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.Skills;

public class SkillsServiceTest {
	
	private SkillsService service;
	
	@Before
	public void initialize() {
		service = new SkillsService();
	}
	
	@Test
	public void should_fetch_personal_info() throws ParseException {
		Skills professionalGoal = service.fetch();
		
		assertThat(professionalGoal.getProgrammingLanguages(), is(asList("Java", "JavaScript", "Spring Boot", "Ionic", "Angular2+", "ReactJs", "HTML")));
		assertThat(professionalGoal.getDatabases(), is(asList("PostgreSQL", "MongoDB", "MySQL", "Firebird")));
		assertThat(professionalGoal.getTechnologies(), is(asList("Docker", "Git", "Spring Framework", "Spring Cloud", "Cordova")));
	}

}
