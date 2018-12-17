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
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;

@RunWith(MockitoJUnitRunner.class)
public class ResumeDeliveryApiTest {
	
	private ResumeDeliveryApi delivery;
	
	@Mock
	private ResumeService service;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	
	@Before
	public void initialize() {
		delivery = new ResumeDeliveryApi(service);
	}
	
	@Test
	public void should_return_resume() throws ParseException {
		Resume resume = createResume();
		given(service.fetch()).willReturn(resume);
		
		Resume apiResponse = delivery.get();
		
		assertThat(apiResponse, is(resume));
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
