package br.com.lepsistemas.aicurriculumvitae.usecase;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

@Service
public class PersonalInfoService implements ApiService {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalInfoService.class);
	
	public PersonalInfo fetch() {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setName("Leandro Boeing Vieira");
		personalInfo.setCity("Florianópolis");
		personalInfo.setState("SC");
		personalInfo.setCountry("Brazil");
		personalInfo.setAddress("Amarilis Street, 70. Apto 302-A. Zip code 88058-505");
		personalInfo.setPhone("+55 48 991108741");
		personalInfo.setEmail("lepfloripa@gmail.com");
		setBirth(personalInfo);
		personalInfo.setNationality("Brazilian");
		return personalInfo;
	}

	private void setBirth(PersonalInfo info) {
		try {
			info.setBirth(sdf.parse("02/22/1985"));
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
