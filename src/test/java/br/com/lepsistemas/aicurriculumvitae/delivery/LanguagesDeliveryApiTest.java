package br.com.lepsistemas.aicurriculumvitae.delivery;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.lepsistemas.aicurriculumvitae.domain.Languages;
import br.com.lepsistemas.aicurriculumvitae.usecase.LanguagesService;

@RunWith(MockitoJUnitRunner.class)
public class LanguagesDeliveryApiTest {
	
	private LanguagesDeliveryApi delivery;
	
	@Mock
	private LanguagesService service;
	
	@Before
	public void initialize() {
		delivery = new LanguagesDeliveryApi(service);
	}
	
	@Test
	public void should_return_languages() {
		Languages languages = new Languages();
		given(service.fetch()).willReturn(languages);
		
		ApiResponse apiResponse = delivery.get();
		
		assertThat(apiResponse.getData(), is(languages));
	}

}
