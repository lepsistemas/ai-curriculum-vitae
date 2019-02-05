package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.Languages;

public class LanguagesServiceTest {
	
	private LanguagesService languageService;
	
	@Before
	public void initialize() {
		languageService = new LanguagesService();
	}
	
	@Test
	public void should_fetch_languages() {
		Languages languages = languageService.fetch();
		
		assertThat(languages.getIdioms().size(), is(2));
		assertThat(languages.getIdioms().get(0).getName(), is("Portuguese"));
		assertThat(languages.getIdioms().get(0).getLevel(), is("Native"));
		assertThat(languages.getIdioms().get(1).getName(), is("English"));
		assertThat(languages.getIdioms().get(1).getLevel(), is("Advanced"));
	}

}
