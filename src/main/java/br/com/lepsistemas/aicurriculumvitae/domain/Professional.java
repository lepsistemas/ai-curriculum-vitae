package br.com.lepsistemas.aicurriculumvitae.domain;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Professional implements Domain {
	
	private List<Experience> experiences;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.getDefault());

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder()
				.append("Since 2010 Leandro has worked with software development. I'll show you his last experiences. ");
		List<Experience> lastExperiences = experiences.subList(0, 2);
		for (Experience experience : lastExperiences) {
			string.append(experience.getTitle());
			string.append(". ");
			string.append(experience.getDescription());
			string.append(" From ");
			string.append(experience.getInitialDate().format(DATE_FORMAT));
			string.append(" until ");
			if (experience.getEndDate() == null) {
				string.append("now. ");
			} else {
				string.append(experience.getEndDate().format(DATE_FORMAT));
				string.append(".");
			}
		}
		return string.toString();
	}

}
