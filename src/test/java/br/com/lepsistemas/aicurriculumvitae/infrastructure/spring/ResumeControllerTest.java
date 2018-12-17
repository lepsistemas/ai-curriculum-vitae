package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@RunWith(SpringRunner.class)
@WebMvcTest(ResumeController.class)
public class ResumeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ResumeDeliveryApi api;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");

	@Test
	public void should_get_resume() throws Exception {
		
		given(api.get()).willReturn(createResume());
		
		MockHttpServletResponse response = mockMvc.perform(get("/resume")).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"personalInfo\":{\"name\":\"Leandro Boeing Vieira\",\"city\":\"Florianopolis\",\"state\":\"SC\",\"country\":\"Brazil\",\"address\":\"Amarilis St, 70.\",\"phone\":\"+55 48 99110-8741\",\"email\":\"lepfloripa@gmail.com\",\"birth\":\"12/30/1984\",\"nationality\":\"Brazilian\"}}"));
	}
	
	private Resume createResume() throws ParseException {
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
		Resume resumeDTO = new Resume();
		resumeDTO.setPersonalInfo(personalInfo);
		return resumeDTO;
	}

}
