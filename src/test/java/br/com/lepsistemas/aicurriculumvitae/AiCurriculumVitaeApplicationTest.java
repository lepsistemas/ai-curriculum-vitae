package br.com.lepsistemas.aicurriculumvitae;

import org.junit.Test;

public class AiCurriculumVitaeApplicationTest {
	
	@Test
	public void spring_smoke_test() {
		AiCurriculumVitaeApplication.main(new String[] { "--spring.output.ansi.enabled=always" } );
	}

}
