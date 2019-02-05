package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lepsistemas.aicurriculumvitae.delivery.ApiResponse;
import br.com.lepsistemas.aicurriculumvitae.delivery.LanguagesDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Idiom;
import br.com.lepsistemas.aicurriculumvitae.domain.Languages;

@RunWith(SpringRunner.class)
@WebMvcTest(LanguagesController.class)
public class LanguagesControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LanguagesDeliveryApi api;
	
	@Test
	public void should_get_languages() throws Exception {
		
		given(api.get()).willReturn(createApiResponseWith(createLanguages()));
		
		MockHttpServletResponse response = mockMvc.perform(get("/languages")).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
		assertThat(response.getContentAsString(), is("{\"idioms\":[{\"name\":\"Portuguese\",\"level\":\"Native\"}]}"));
	}
	
	private ApiResponse createApiResponseWith(Languages languages) {
		return new ApiResponse(languages);
	}

	private Languages createLanguages() {
		Languages languages = new Languages();
		Idiom portuguese = new Idiom();
		portuguese.setName("Portuguese");
		portuguese.setLevel("Native");
		languages.setIdioms(asList(portuguese));
		return languages;
	}

}
