package br.com.lepsistemas.aicurriculumvitae.delivery;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.Skills;
import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

@RunWith(MockitoJUnitRunner.class)
public class SkillsDeliveryApiTest {
	
	private SkillsDeliveryApi api;
	
	@Mock
	private SkillsService service;
	
	@Before
	public void initialize() {
		api = new SkillsDeliveryApi(service);
	}
	
	@Test
	public void should_return_skills() throws ParseException {
		Skills skills = createSkills();
		given(service.fetch()).willReturn(skills);
		
		ApiResponse apiResponse = api.get();
		
		assertThat(apiResponse.getData(), is(skills));
	}

	private Skills createSkills() {
		return new Skills(asList("Java"), asList("MongoDB"));
	}

}
