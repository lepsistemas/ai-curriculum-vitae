package br.com.lepsistemas.aicurriculumvitae.delivery;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;
import br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.RequestDto;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalGoalService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.exceptions.InvalidActionException;

@RunWith(MockitoJUnitRunner.class)
public class WebhookDeliveryApiTest {
	
	private WebhookDeliveryApi delivery;
	
	@Mock
	private ResumeService resumeService;
	
	@Mock
	private PersonalInfoService personalInfoService;
	
	@Mock
	private ProfessionalGoalService professionalGoalService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	
	@Before
	public void initialize() {
		delivery = new WebhookDeliveryApi(resumeService, personalInfoService, professionalGoalService);
	}
	
	@Test(expected = InvalidActionException.class)
	public void should_throw_invalid_action_exception() {
		RequestDto request = createRequestFor("XXX");
		delivery.get(request);
	}
	
	@Test
	public void should_return_all() throws Exception {
		Resume resume = createResume();
		given(resumeService.fetch()).willReturn(resume);
		
		RequestDto request = createRequestFor(RequestDto.ALL);
		Resume apiResponse = (Resume) delivery.get(request);
		
		assertThat(apiResponse, is(resume));
	}
	
	@Test
	public void should_return_personal_info() throws Exception {
		Resume resume = createResume();
		given(personalInfoService.fetch()).willReturn(resume.getPersonalInfo());
		
		RequestDto request = createRequestFor(RequestDto.PERSONAL_INFO);
		PersonalInfo apiResponse = (PersonalInfo) delivery.get(request);
		
		assertThat(apiResponse, is(resume.getPersonalInfo()));
	}
	
	@Test
	public void should_return_professional_goal() throws Exception {
		Resume resume = createResume();
		given(professionalGoalService.fetch()).willReturn(resume.getProfessionalGoal());
		
		RequestDto request = createRequestFor(RequestDto.PROFESSIONAL_GOAL);
		PersonalInfo apiResponse = (PersonalInfo) delivery.get(request);
		
		assertThat(apiResponse, is(resume.getProfessionalGoal()));
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
		personalInfo.setBirth(sdf.parse("02/22/1985"));
		personalInfo.setNationality("Brazilian");
		resume.setPersonalInfo(personalInfo);
		return resume;
	}

}
