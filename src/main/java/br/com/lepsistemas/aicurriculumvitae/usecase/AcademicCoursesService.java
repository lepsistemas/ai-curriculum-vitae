package br.com.lepsistemas.aicurriculumvitae.usecase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lepsistemas.aicurriculumvitae.domain.AcademicCourse;
import br.com.lepsistemas.aicurriculumvitae.usecase.exception.DateParseException;

@Service
public class AcademicCoursesService {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	
	public List<AcademicCourse> findAll() {
		List<AcademicCourse> courses = new ArrayList<AcademicCourse>();
		courses.add(new AcademicCourse("Bachelor of Computer Science", "Federal University of Santa Catarina - UFSC", convertTextToDate("12/31/2009")));
		courses.add(new AcademicCourse("Specialist in Software Engineering", "Federal University of Santa Catarina - UFSC", convertTextToDate("12/31/2012")));
		courses.add(new AcademicCourse("Microservices with Spring Cloud and Netflix OSS", "VOffice", convertTextToDate("12/31/2017")));
		return courses;
	}
	
	private Date convertTextToDate(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new DateParseException("Could not convert date " + date);
		}
	}

}
