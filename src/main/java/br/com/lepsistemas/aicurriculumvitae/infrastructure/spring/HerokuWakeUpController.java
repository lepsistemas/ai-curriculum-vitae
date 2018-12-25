package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wakeup")
public class HerokuWakeUpController {
	
	@PostMapping
	public void wakeup() {
	}

}
