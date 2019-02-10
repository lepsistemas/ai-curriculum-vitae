package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.ProfessionalDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Professional;

@RestController
public class ProfessionalController {
	
	@Autowired
	private ProfessionalDeliveryApi api;
	
	@GetMapping("/professional-experiences")
	public ResponseEntity<Professional> get() {
		Professional experiences = (Professional) api.get().getData();
		return ResponseEntity.ok(experiences);
	}

}
