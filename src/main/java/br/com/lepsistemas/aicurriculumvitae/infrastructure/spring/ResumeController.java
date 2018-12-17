package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDto;
import br.com.lepsistemas.aicurriculumvitae.domain.Resume;

@RestController
public class ResumeController {
	
	@Autowired
	private ResumeDeliveryApi api;
	
	@GetMapping("/resume")
	public ResponseEntity<ResumeDto> get() throws ParseException {
		Resume resume = api.get();
		ResumeDto response = new ResumeDto(resume);
		return ResponseEntity.ok(response);
	}

}
