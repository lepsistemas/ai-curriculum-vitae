package br.com.lepsistemas.aicurriculumvitae.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PersonalInfoTest {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	
	@Test
	public void should_calculate_age() throws Exception {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setBirth(sdf.parse("02/22/1985"));
		
		assertThat(personalInfo.getAge(), Matchers.is(34));
	}
	
	@Test
	public void should_convert_to_string() throws Exception {
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setName("Leandro Boeing Vieira");
		personalInfo.setCity("Florianópolis");
		personalInfo.setState("SC");
		personalInfo.setCountry("Brazil");
		personalInfo.setAddress("Amarilis Street, 70. Apto 302-A. Zip code 88058-505");
		personalInfo.setPhone("+55 48 991108741");
		personalInfo.setEmail("lepfloripa@gmail.com");
		personalInfo.setBirth(sdf.parse("02/22/1985"));
		personalInfo.setNationality("Brazilian");
		
		assertThat(personalInfo.toString(), equalTo("Leandro Boeing Vieira lives in Amarilis Street, 70. Apto 302-A. Zip code 88058-505, Florianópolis - SC, Brazil. His phone number is +55 48 991108741. You can also be in touch by e-mail, which is lepfloripa@gmail.com. He is 34 years old and his nationality is Brazilian."));
	}

}
