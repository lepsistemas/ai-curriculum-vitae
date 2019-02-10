package br.com.lepsistemas.aicurriculumvitae.usecase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.lepsistemas.aicurriculumvitae.domain.Professional;

public class ProfessionalServiceTest {
	
	private ProfessionalService service;
	
	@Before
	public void initialize() {
		service = new ProfessionalService();
	}
	
	@Test
	public void should_fetch_professional_experiences() {
		Professional professionalExperiences = service.fetch();
		
		assertThat(professionalExperiences.getExperiences().size(), is(4));
		assertThat(professionalExperiences.getExperiences().get(0).getTitle(), is("Software Developer at Softplan"));
		assertThat(professionalExperiences.getExperiences().get(0).getDescription(), is("Agile developer focused in optimized solutions, making backlog refinements with the Product Owner and team to reach the customers success. Working in an ERP for the Construction area, continuous delivering MVPs using Java EE and Spring to build REST web services to connect to the legacy monolith."));
		assertThat(professionalExperiences.getExperiences().get(0).getInitialDate(), is(LocalDate.of(2018, 1, 1)));
		assertThat(professionalExperiences.getExperiences().get(0).getEndDate(), nullValue());
		
		assertThat(professionalExperiences.getExperiences().get(1).getTitle(), is("Scrum Master at Softplan"));
		assertThat(professionalExperiences.getExperiences().get(1).getDescription(), is("Change agent, coach, leader-server, helping the development team identify and act on problems, always focusing on empowerment, autonomy and self-organization of the team, watching Agile metrics to improve performance."));
		assertThat(professionalExperiences.getExperiences().get(1).getInitialDate(), is(LocalDate.of(2016, 6, 1)));
		assertThat(professionalExperiences.getExperiences().get(1).getEndDate(), is(LocalDate.of(2017, 12, 31)));
		
		assertThat(professionalExperiences.getExperiences().get(2).getTitle(), is("Analyst Java Developer at Softplan"));
		assertThat(professionalExperiences.getExperiences().get(2).getDescription(), is("Participation in the analysis, specification and implementation of software requirements for the largest ERP for Brazil's Construction Industry, Sienge, using Java EE, Hibernate, EJB and Struts."));
		assertThat(professionalExperiences.getExperiences().get(2).getInitialDate(), is(LocalDate.of(2012, 4, 1)));
		assertThat(professionalExperiences.getExperiences().get(2).getEndDate(), is(LocalDate.of(2016, 5, 31)));
		
		assertThat(professionalExperiences.getExperiences().get(3).getTitle(), is("Java Developer at Trier Sistemas"));
		assertThat(professionalExperiences.getExperiences().get(3).getDescription(), is("Working as Java developer for a Pharmacy ERP using JAVA EE, Hibernate and JSP with Vanilla Javascript."));
		assertThat(professionalExperiences.getExperiences().get(3).getInitialDate(), is(LocalDate.of(2010, 1, 1)));
		assertThat(professionalExperiences.getExperiences().get(3).getEndDate(), is(LocalDate.of(2012, 3, 31)));
	}

}
