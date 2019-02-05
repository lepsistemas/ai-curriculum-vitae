package br.com.lepsistemas.aicurriculumvitae.domain;

import java.util.List;

public class Languages implements Domain {

	private List<Idiom> idioms;

	public List<Idiom> getIdioms() {
		return idioms;
	}

	public void setIdioms(List<Idiom> idioms) {
		this.idioms = idioms;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder()
				.append("Leandro speaks ")
				.append(idioms.size())
				.append(" languages. ");
		for (Idiom language : idioms) {
			string.append("He speaks ")
			.append(language.getName())
			.append(" in a(n) ")
			.append(language.getLevel())
			.append(" level.");
		}
		return string.toString();
	}

}
