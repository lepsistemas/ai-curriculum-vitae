package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lepsistemas.aicurriculumvitae.delivery.ApiResponse;
import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Idiom;
import br.com.lepsistemas.aicurriculumvitae.domain.Languages;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Experience;
import br.com.lepsistemas.aicurriculumvitae.domain.Professional;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;
import br.com.lepsistemas.aicurriculumvitae.domain.Skills;

@RunWith(SpringRunner.class)
@WebMvcTest(ResumeController.class)
public class ResumeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ResumeDeliveryApi api;

	@Test
	public void should_get_resume() throws Exception {
		
		given(api.get()).willReturn(createApiResponseWith(createResume()));
		
		MockHttpServletResponse response = mockMvc.perform(get("/resume")).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"personalInfo\":{\"name\":\"Leandro Boeing Vieira\",\"city\":\"Florianopolis\",\"state\":\"SC\",\"country\":\"Brazil\",\"address\":\"Amarilis St, 70.\",\"phone\":\"+55 48 99110-8741\",\"email\":\"lepfloripa@gmail.com\",\"birth\":\"1985-02-22\",\"nationality\":\"Brazilian\"},\"languages\":{\"idioms\":[{\"name\":\"Portuguese\",\"level\":\"Native\"}]},\"skills\":{\"programming\":[\"Java\"],\"databases\":[\"Mongo\"]},\"professional\":{\"experiences\":[{\"title\":\"Developer\",\"description\":\"Develop a system\",\"initialDate\":\"2018-01-01\",\"endDate\":null}]}}"));
	}
	
	private ApiResponse createApiResponseWith(Resume resume) {
		return new ApiResponse(resume);
	}
	
	private Resume createResume() throws ParseException {
		Resume resume = new Resume();
		
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setName("Leandro Boeing Vieira");
		personalInfo.setCity("Florianopolis");
		personalInfo.setState("SC");
		personalInfo.setCountry("Brazil");
		personalInfo.setAddress("Amarilis St, 70.");
		personalInfo.setPhone("+55 48 99110-8741");
		personalInfo.setEmail("lepfloripa@gmail.com");
		personalInfo.setBirth(LocalDate.of(1985, 2, 22));
		personalInfo.setNationality("Brazilian");
		resume.setPersonalInfo(personalInfo);
		
		Skills skills = new Skills(asList("Java"), asList("Mongo"));
		resume.setSkills(skills);
		
		Languages languages = new Languages();
		Idiom portuguese = new Idiom();
		portuguese.setName("Portuguese");
		portuguese.setLevel("Native");
		languages.setIdioms(asList(portuguese));
		resume.setLanguages(languages);
		
		Professional experiences = new Professional();
		Experience developer = new Experience();
		developer.setTitle("Developer");
		developer.setInitialDate(LocalDate.of(2018, 1, 1));
		developer.setDescription("Develop a system");
		experiences.setExperiences(asList(developer));
		resume.setProfessional(experiences);
		
		return resume;
	}

}
