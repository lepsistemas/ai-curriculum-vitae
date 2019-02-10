package br.com.lepsistemas.aicurriculumvitae.delivery;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.Professional;
import br.com.lepsistemas.aicurriculumvitae.usecase.ProfessionalService;

@RunWith(MockitoJUnitRunner.class)
public class ProfessionalDeliveryApiTest {
	
	private ProfessionalDeliveryApi api;
	
	@Mock
	private ProfessionalService service;
	
	@Before
	public void initialize() {
		api = new ProfessionalDeliveryApi(service);
	}
	
	@Test
	public void should_return_professional_experiences() {
		Professional professionalExperiences = new Professional();
		when(service.fetch()).thenReturn(professionalExperiences);
		
		ApiResponse apiResponse = api.get();
		
		assertThat(apiResponse.getData(), is(professionalExperiences));
	}

}
