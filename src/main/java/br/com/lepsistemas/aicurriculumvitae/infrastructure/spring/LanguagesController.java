package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.LanguagesDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Languages;

@RestController
public class LanguagesController {
	
	@Autowired
	private LanguagesDeliveryApi api;
	
	@GetMapping("/languages")
	public ResponseEntity<Languages> get() {
		Languages languages = (Languages) api.get().getData();
		return ResponseEntity.ok(languages);
	}

}
