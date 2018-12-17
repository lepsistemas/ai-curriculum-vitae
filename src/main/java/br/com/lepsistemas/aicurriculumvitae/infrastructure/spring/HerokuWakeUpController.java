package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wakeup")
public class HerokuWakeUpController {
	
	Logger LOG = LoggerFactory.getLogger(HerokuWakeUpController.class);
	
	@PostMapping
	public void wakeup() {
		LOG.info("Waking up...");
	}

}
