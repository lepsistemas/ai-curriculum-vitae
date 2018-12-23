package br.com.lepsistemas.aicurriculumvitae.usecase;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

@Service
public class PersonalInfoService implements ApiService {
	
	public PersonalInfo fetch() {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setName("Leandro Boeing Vieira");
		personalInfo.setCity("Florianópolis");
		personalInfo.setState("SC");
		personalInfo.setCountry("Brazil");
		personalInfo.setAddress("Amarilis Street, 70. Apto 302-A. Zip code 88058-505");
		personalInfo.setPhone("+55 48 991108741");
		personalInfo.setEmail("lepfloripa@gmail.com");
		personalInfo.setBirth(LocalDate.of(1985, 2, 22));
		personalInfo.setNationality("Brazilian");
		return personalInfo;
	}

}
