package br.com.lepsistemas.aicurriculumvitae.usecase;

import static java.util.Arrays.asList;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.Skills;

@Service
public class SkillsService implements ApiService {

	public Skills fetch() {
		return new Skills(
				asList("Java", "JavaScript", "Spring Boot", "Ionic", "Angular2+", "ReactJs", "HTML"),
				asList("PostgreSQL", "MongoDB", "MySQL", "Firebird"));
	}

}
