package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lepsistemas.aicurriculumvitae.delivery.ApiResponse;
import br.com.lepsistemas.aicurriculumvitae.delivery.ProfessionalDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Experience;
import br.com.lepsistemas.aicurriculumvitae.domain.Professional;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfessionalController.class)
public class ProfessionalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProfessionalDeliveryApi api;
	
	@Test
	public void should_get_professional_experiences() throws Exception {
		
		given(api.get()).willReturn(createApiResponseWith(createProfessionalExperiences()));
		
		MockHttpServletResponse response = mockMvc.perform(get("/professional-experiences")).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"experiences\":[{\"title\":\"Software Developer at Softplan\",\"description\":\"Agile developer focused in optimized solutions, making backlog refinements with the Product Owner and team to reach the customers success.\",\"initialDate\":\"2018-02-01\",\"endDate\":null}]}"));
		
	}

	private ApiResponse createApiResponseWith(Professional experiences) {
		return new ApiResponse(experiences);
	}

	private Professional createProfessionalExperiences() {
		Professional experiences = new Professional();
		Experience softplan = new Experience();
		softplan.setTitle("Software Developer at Softplan");
		softplan.setDescription("Agile developer focused in optimized solutions, making backlog refinements with the Product Owner and team to reach the customers success.");
		LocalDate initialDate = LocalDate.parse("01/02/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		softplan.setInitialDate(initialDate);
		experiences.setExperiences(asList(softplan));
		return experiences;
	}

}
