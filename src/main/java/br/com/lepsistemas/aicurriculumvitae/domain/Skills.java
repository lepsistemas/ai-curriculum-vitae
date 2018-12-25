package br.com.lepsistemas.aicurriculumvitae.domain;

import java.util.List;

public class Skills implements Domain {

	private List<String> programmingLanguages;
	private List<String> databases;
	private List<String> technologies;

	public Skills(List<String> programmingLanguages, List<String> databases, List<String> technologies) {
		this.programmingLanguages = programmingLanguages;
		this.databases = databases;
		this.technologies = technologies;
	}
	
	public List<String> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public List<String> getDatabases() {
		return databases;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Leandro has knowledge in many languages and technologies. ");
		result.append("His programming skills include ");
		result.append(String.join(", ", programmingLanguages));
		result.append(". ");
		result.append("Regarding databases, he has worked with these: ");
		result.append(String.join(", ", databases));
		result.append(". ");
		result.append("The technologies he uses are ");
		result.append(String.join(", ", technologies));
		result.append(".");
		return result.toString();
	}

}
