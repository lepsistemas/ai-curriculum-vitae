package br.com.lepsistemas.aicurriculumvitae.domain;

import java.util.List;

public class Skills implements Domain {

	private List<String> programming;
	private List<String> databases;

	public Skills(List<String> programming, List<String> databases) {
		this.programming = programming;
		this.databases = databases;
	}
	
	public List<String> getProgramming() {
		return programming;
	}

	public List<String> getDatabases() {
		return databases;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Leandro has knowledge in many languages and technologies. ");
		result.append("His programming skills include ");
		result.append(String.join(", ", programming));
		result.append(". ");
		result.append("Regarding databases, he has worked with these: ");
		result.append(String.join(", ", databases));
		result.append(".");
		return result.toString();
	}

}
