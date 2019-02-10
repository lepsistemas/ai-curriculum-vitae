package br.com.lepsistemas.aicurriculumvitae.usecase;

import static java.util.Arrays.asList;

import java.time.LocalDate;

import br.com.lepsistemas.aicurriculumvitae.domain.Experience;
import br.com.lepsistemas.aicurriculumvitae.domain.Professional;

public class ProfessionalService implements ApiService {

	@Override
	public Professional fetch() {
		Professional professionalExperiences = new Professional();
		professionalExperiences.setExperiences(asList(developerAtSoftplan(), scrumMasterAtSoftplan(), analystAtSoftplan(), developerAtTrier()));
		return professionalExperiences;
	}

	private Experience developerAtSoftplan() {
		Experience experience = new Experience();
		experience.setTitle("Software Developer at Softplan");
		experience.setDescription("Agile developer focused in optimized solutions, making backlog refinements with the Product Owner and team to reach the customers success. Working in an ERP for the Construction area, continuous delivering MVPs using Java EE and Spring to build REST web services to connect to the legacy monolith.");
		experience.setInitialDate(LocalDate.of(2018, 1, 1));
		return experience;
	}
	
	private Experience scrumMasterAtSoftplan() {
		Experience experience = new Experience();
		experience.setTitle("Scrum Master at Softplan");
		experience.setDescription("Change agent, coach, leader-server, helping the development team identify and act on problems, always focusing on empowerment, autonomy and self-organization of the team, watching Agile metrics to improve performance.");
		experience.setInitialDate(LocalDate.of(2016, 6, 1));
		experience.setEndDate(LocalDate.of(2017, 12, 31));
		return experience;
	}
	
	private Experience analystAtSoftplan() {
		Experience experience = new Experience();
		experience.setTitle("Analyst Java Developer at Softplan");
		experience.setDescription("Participation in the analysis, specification and implementation of software requirements for the largest ERP for Brazil's Construction Industry, Sienge, using Java EE, Hibernate, EJB and Struts.");
		experience.setInitialDate(LocalDate.of(2012, 4, 1));
		experience.setEndDate(LocalDate.of(2016, 5, 31));
		return experience;
	}
	
	private Experience developerAtTrier() {
		Experience experience = new Experience();
		experience.setTitle("Java Developer at Trier Sistemas");
		experience.setDescription("Working as Java developer for a Pharmacy ERP using JAVA EE, Hibernate and JSP with Vanilla Javascript.");
		experience.setInitialDate(LocalDate.of(2010, 1, 1));
		experience.setEndDate(LocalDate.of(2012, 3, 31));
		return experience;
	}

}
