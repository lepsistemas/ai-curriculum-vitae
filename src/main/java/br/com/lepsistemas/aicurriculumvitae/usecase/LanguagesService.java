package br.com.lepsistemas.aicurriculumvitae.usecase;

import static java.util.Arrays.asList;

import br.com.lepsistemas.aicurriculumvitae.domain.Idiom;
import br.com.lepsistemas.aicurriculumvitae.domain.Languages;

public class LanguagesService implements ApiService {

	@Override
	public Languages fetch() {
		Languages languages = new Languages();
		languages.setIdioms(asList(portuguese(), english()));
		return languages;
	}

	private Idiom portuguese() {
		Idiom language = new Idiom();
		language.setName("Portuguese");
		language.setLevel("Native");
		return language;
	}
	
	private Idiom english() {
		Idiom language = new Idiom();
		language.setName("English");
		language.setLevel("Advanced");
		return language;
	}

}
