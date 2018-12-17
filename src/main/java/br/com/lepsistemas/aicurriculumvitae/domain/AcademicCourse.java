package br.com.lepsistemas.aicurriculumvitae.domain;

import java.util.Date;

public class AcademicCourse implements Domain {
	
	private String title;
	private String institution;
	private Date conclusion;
	
	public AcademicCourse() {
	}

	public AcademicCourse(String title, String institution, Date conclusion) {
		this.title = title;
		this.institution = institution;
		this.conclusion = conclusion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Date getConclusion() {
		return conclusion;
	}

	public void setConclusion(Date conclusion) {
		this.conclusion = conclusion;
	}

}
