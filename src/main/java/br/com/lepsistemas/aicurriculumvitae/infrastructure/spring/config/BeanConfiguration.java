package br.com.lepsistemas.aicurriculumvitae.infrastructure.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lepsistemas.aicurriculumvitae.delivery.PersonalInfoDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.delivery.ResumeDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.delivery.WebhookDeliveryApi;
import br.com.lepsistemas.aicurriculumvitae.usecase.PersonalInfoService;
import br.com.lepsistemas.aicurriculumvitae.usecase.ResumeService;
import br.com.lepsistemas.aicurriculumvitae.usecase.SkillsService;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public ResumeDeliveryApi resumeDeliveryApi() {
		return new ResumeDeliveryApi(resumeService());
	}
	
	@Bean
	public PersonalInfoDeliveryApi personalInfoDeliveryApi() {
		return new PersonalInfoDeliveryApi(personalInfoService());
	}
	
	@Bean
	public WebhookDeliveryApi webhookDeliveryApi() {
		return new WebhookDeliveryApi(resumeService(), personalInfoService(), skillsService());
	}

	@Bean
	public ResumeService resumeService() {
		return new ResumeService(personalInfoService());
	}

	@Bean
	public PersonalInfoService personalInfoService() {
		return new PersonalInfoService();
	}
	
	@Bean
	public SkillsService skillsService() {
		return new SkillsService();
	}

}
