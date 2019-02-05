package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

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
import br.com.lepsistemas.aicurriculumvitae.delivery.PersonalInfoDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonalInfoController.class)
public class PersonalInfoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonalInfoDeliveryApi api;
	
	@Test
	public void should_get_personal_info() throws Exception {
		
		given(api.get()).willReturn(createApiResponseWith(createPersonalInfo()));
		
		MockHttpServletResponse response = mockMvc.perform(get("/personal-info")).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"name\":\"Leandro Boeing Vieira\",\"city\":\"Florianopolis\",\"state\":\"SC\",\"country\":\"Brazil\",\"address\":\"Amarilis St, 70.\",\"phone\":\"+55 48 99110-8741\",\"email\":\"lepfloripa@gmail.com\",\"birth\":\"1985-02-22\",\"nationality\":\"Brazilian\"}"));
	}
	
	private ApiResponse createApiResponseWith(PersonalInfo personalInfo) {
		return new ApiResponse(personalInfo);
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
