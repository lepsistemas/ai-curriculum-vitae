package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

public class PersonalInfoServiceTest {
	
	private PersonalInfoService service;

	@Before
	public void initialize() {
		service = new PersonalInfoService();
	}
	
	@Test
	public void should_fetch_personal_info() throws ParseException {
		PersonalInfo personalInfo = service.fetch();
		
		assertThat(personalInfo.getName(), is("Leandro Boeing Vieira"));
		assertThat(personalInfo.getCity(), is("Florianópolis"));
		assertThat(personalInfo.getState(), is("SC"));
		assertThat(personalInfo.getCountry(), is("Brazil"));
		assertThat(personalInfo.getAddress(), is("Amarilis Street, 70. Apto 302-A. Zip code 88058-505"));
		assertThat(personalInfo.getPhone(), is("+55 48 991108741"));
		assertThat(personalInfo.getEmail(), is("lepfloripa@gmail.com"));
		assertThat(personalInfo.getBirth(), is(LocalDate.of(1985, 2, 22)));
		assertThat(personalInfo.getNationality(), is("Brazilian"));
	}

}
