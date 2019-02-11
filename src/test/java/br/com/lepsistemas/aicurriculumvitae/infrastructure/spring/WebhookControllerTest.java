package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lepsistemas.aicurriculumvitae.delivery.WebhookDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;
import br.com.lepsistemas.aicurriculumvitae.usecase.exception.InvalidActionException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WebhookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WebhookDeliveryApi api;
	
	@Test
	public void should_throw_invalid_action_exception() throws Exception {
		RequestDto request = createRequestFor("XXX");
		given(api.get(request)).willThrow(new InvalidActionException("Invalid action"));
		
		MockHttpServletResponse response = mockMvc.perform(
				post("/webhook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request))
		).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(422));
		assertThat(response.getContentAsString(), is("{\"status\":422,\"message\":\"Invalid action\"}"));
	}

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
		assertThat(response.getContentAsString(), is("{\"speech\":\"Leandro's curriculum is vast. I think you'll get tired of listening entirely.\",\"displayText\":\"Leandro's curriculum is vast. I think you'll get tired of listening entirely.\"}"));
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
		assertThat(response.getContentAsString(), is("{\"speech\":\"Leandro Boeing Vieira lives in Amarilis St, 70, Florianopolis - SC, Brazil. His phone number is +55 48 99110-8741. You can also be in touch by e-mail, which is lepfloripa@gmail.com. Date birth is 02/22/1985 and his nationality is Brazilian.\",\"displayText\":\"Leandro Boeing Vieira lives in Amarilis St, 70, Florianopolis - SC, Brazil. His phone number is +55 48 99110-8741. You can also be in touch by e-mail, which is lepfloripa@gmail.com. Date birth is 02/22/1985 and his nationality is Brazilian.\"}"));
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
		personalInfo.setBirth(LocalDate.of(1985, 2, 22));
		personalInfo.setNationality("Brazilian");
		Resume resume = new Resume();
		resume.setPersonalInfo(personalInfo);
		return resume;
	}

}
