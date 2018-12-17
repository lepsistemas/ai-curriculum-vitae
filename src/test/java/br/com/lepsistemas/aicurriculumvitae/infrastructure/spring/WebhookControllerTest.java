package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lepsistemas.aicurriculumvitae.delivery.WebhookDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@RunWith(SpringRunner.class)
@WebMvcTest(WebhookController.class)
public class WebhookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WebhookDeliveryApi api;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");

	@Test
	public void should_retrieve_all() throws Exception {
		
		RequestDto request = createRequestFor(RequestDto.ALL);
		given(api.get(request)).willReturn(createResume());
		
		MockHttpServletResponse response = mockMvc.perform(
				post("/webhook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request))
		).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"speech\":\"Leandro's curriculum is vast. I think you'll get tired of listening entirely. Please, tap on the right button and I'll take you to his Curriculum Vitae page. From there, you'll be able to send it to your e-mail.\",\"displayText\":\"Leandro's curriculum is vast. I think you'll get tired of listening entirely. Please, tap on the right button and I'll take you to his Curriculum Vitae page. From there, you'll be able to send it to your e-mail.\"}"));
	}
	
	@Test
	public void should_retrieve_personal_info() throws Exception {
		
		RequestDto request = createRequestFor(RequestDto.PERSONAL_INFO);
		given(api.get(request)).willReturn(createResume().getPersonalInfo());
		
		MockHttpServletResponse response = mockMvc.perform(
				post("/webhook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request))
		).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"speech\":\"Leandro Boeing Vieira lives in Amarilis St, 70, Florianopolis - SC, Brazil. His phone number is +55 48 99110-8741. You can also be in touch by e-mail, which is lepfloripa@gmail.com. He is 34 years old and his nationality is Brazilian.\",\"displayText\":\"Leandro Boeing Vieira lives in Amarilis St, 70, Florianopolis - SC, Brazil. His phone number is +55 48 99110-8741. You can also be in touch by e-mail, which is lepfloripa@gmail.com. He is 34 years old and his nationality is Brazilian.\"}"));
	}

	private RequestDto createRequestFor(String action) {
		RequestDto request = new RequestDto();
		RequestDto.ResultDto result = new RequestDto.ResultDto();
		result.setAction(action);
		request.setResult(result);
		return request;
	}
	
	private Resume createResume() throws ParseException {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setName("Leandro Boeing Vieira");
		personalInfo.setCity("Florianopolis");
		personalInfo.setState("SC");
		personalInfo.setCountry("Brazil");
		personalInfo.setAddress("Amarilis St, 70");
		personalInfo.setPhone("+55 48 99110-8741");
		personalInfo.setEmail("lepfloripa@gmail.com");
		personalInfo.setBirth(sdf.parse("02/22/1985"));
		personalInfo.setNationality("Brazilian");
		Resume resume = new Resume();
		resume.setPersonalInfo(personalInfo);
		return resume;
	}

}
