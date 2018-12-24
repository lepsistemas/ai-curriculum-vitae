package br.com.lepsistemas.aicurriculumvitae.delivery;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;

@RunWith(MockitoJUnitRunner.class)
public class PersonalInfoDeliveryApiTest {
	
	private PersonalInfoDeliveryApi delivery;
	
	@Mock
	private PersonalInfoService service;
	
	@Before
	public void initialize() {
		delivery = new PersonalInfoDeliveryApi(service);
	}
	
	@Test
	public void should_return_personal_info() throws ParseException {
		PersonalInfo personalInfo = createPersonalInfo();
		given(service.fetch()).willReturn(personalInfo);
		
		ApiResponse apiResponse = delivery.get();
		
		assertThat(apiResponse.getData(), is(personalInfo));
	}

	private PersonalInfo createPersonalInfo() throws ParseException {
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
		return personalInfo;
	}

}
