package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.PersonalInfoDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

@RestController
public class PersonalInfoController {
	
	@Autowired
	private PersonalInfoDeliveryApi api;
	
	@GetMapping("/personal-info")
	public ResponseEntity<PersonalInfo> get() {
		PersonalInfo personalInfo = (PersonalInfo) api.get().getData();
		return ResponseEntity.ok(personalInfo);
	}

}
