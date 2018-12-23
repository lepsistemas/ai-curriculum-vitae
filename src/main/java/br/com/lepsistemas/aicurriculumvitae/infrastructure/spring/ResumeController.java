package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@RestController
public class ResumeController {
	
	@Autowired
	private ResumeDeliveryApi api;
	
	@GetMapping("/resume")
	public ResponseEntity<Resume> get() throws ParseException {
		Resume resume = (Resume) api.get().getData();
		return ResponseEntity.ok(resume);
	}

}
