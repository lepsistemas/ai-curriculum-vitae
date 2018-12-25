package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HerokuWakeUpControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_wake_up() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(
				post("/wakeup")
				.contentType(MediaType.APPLICATION_JSON)
		).andReturn().getResponse();
		
		assertThat(response.getStatus(), is(200));
	}

}
