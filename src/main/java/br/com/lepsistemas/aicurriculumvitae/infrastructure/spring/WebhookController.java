package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.WebhookDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Domain;

@RestController
public class WebhookController {
	
	@Autowired
	private WebhookDeliveryApi api;
	
	@PostMapping("/webhook")
	public ResponseEntity<?> webhook(@RequestBody RequestDto request) {
		Domain domain = api.get(request);
		return ResponseEntity.ok().body(new ResponseDto(domain.toString()));
	}

}
