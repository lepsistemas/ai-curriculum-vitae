package br.com.lepsistemas.aicurriculumvitae.delivery;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.Domain;
import br.com.lepsistemas.aicurriculumvitae.domain.Experience;
import br.com.lepsistemas.aicurriculumvitae.domain.Idiom;
import br.com.lepsistemas.aicurriculumvitae.domain.Languages;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Professional;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;
import br.com.lepsistemas.aicurriculumvitae.domain.Skills;
import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.LanguagesService;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

@RunWith(MockitoJUnitRunner.class)
public class WebhookDeliveryApiTest {
	
	private WebhookDeliveryApi api;
	
	@Mock
	private ResumeService resumeService;
	
	@Mock
	private PersonalInfoService personalInfoService;
	
	@Mock
	private SkillsService skillsService;

	@Mock
	private LanguagesService languagesService;

	@Mock
	private ProfessionalService professionalExperiencesService;
	
	@Before
	public void initialize() {
		api = new WebhookDeliveryApi(resumeService, personalInfoService, skillsService, languagesService, professionalExperiencesService);
	}
	
	@Test
	public void should_return_all() throws Exception {
		Resume resume = createResume();
		given(resumeService.fetch()).willReturn(resume);
		
		RequestDto request = createRequestFor(RequestDto.ALL);
		Domain apiResponse = api.get(request);
		
		assertThat(apiResponse, notNullValue());
		assertThat(apiResponse, is(resume));
	}
	
	@Test
	public void should_return_personal_info() throws Exception {
		Resume resume = createResume();
		given(personalInfoService.fetch()).willReturn(resume.getPersonalInfo());
		
		RequestDto request = createRequestFor(RequestDto.PERSONAL_INFO);
		Domain apiResponse = api.get(request);
		
		assertThat(apiResponse, notNullValue());
		assertThat(apiResponse, is(resume.getPersonalInfo()));
	}
	
	@Test
	public void should_return_skills() throws Exception {
		Resume resume = createResume();
		given(skillsService.fetch()).willReturn(resume.getSkills());
		
		RequestDto request = createRequestFor(RequestDto.SKILLS);
		Domain apiResponse = api.get(request);
		
		assertThat(apiResponse, notNullValue());
		assertThat(apiResponse, is(resume.getSkills()));
	}
	
	@Test
	public void should_return_languages() throws Exception {
		Resume resume = createResume();
		given(languagesService.fetch()).willReturn(resume.getLanguages());
		
		RequestDto request = createRequestFor(RequestDto.LANGUAGES);
		Domain apiResponse = api.get(request);
		
		assertThat(apiResponse, notNullValue());
		assertThat(apiResponse, is(resume.getLanguages()));
	}
	
	@Test
	public void should_return_professional_experiences() throws Exception {
		Resume resume = createResume();
		given(professionalExperiencesService.fetch()).willReturn(resume.getProfessional());
		
		RequestDto request = createRequestFor(RequestDto.PROFESSIONAL_EXPERIENCES);
		Domain apiResponse = api.get(request);
		
		assertThat(apiResponse, notNullValue());
		assertThat(apiResponse, is(resume.getProfessional()));
	}

	private RequestDto createRequestFor(String action) {
		RequestDto request = new RequestDto();
		RequestDto.ResultDto result = new RequestDto.ResultDto();
		result.setAction(action);
		request.setResult(result);
		return request;
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
