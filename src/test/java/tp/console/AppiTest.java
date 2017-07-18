package tp.console;

import tp.service.CalculService;
import tp.service.CalculServiceTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;





public class AppiTest {

	//In the braquets it is necessary to introduce the name of the class
	private static final Logger LOG = LoggerFactory.getLogger(AppiTest.class);
	
	@Rule

	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private Appi app;

	private CalculService calculService;

	@Before

	public void setUp() throws Exception {

	//this.calculService = new CalculService();
	this.calculService = mock(CalculService.class);
	this.app = new Appi(new Scanner(System.in), calculService);

	}

	@Test

	public void testAfficherTitre() throws Exception {

	this.app.afficherTitre();

	String logConsole = systemOutRule.getLog();

	assertThat(logConsole).contains("**** Application Calculatrice ****");

	}


	@Test

	public void testEvaluer() throws Exception {

	LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");

	String expression = "1+34";
	when(calculService.additionner(expression)).thenReturn(35);

	LOG.info("Lorsque la méthode evaluer est invoquée");
	
	this.app.evaluer(expression);

	LOG.info("Alors le service est invoqué avec l'expression {}", expression);
	
	verify(calculService).additionner(expression); 

	LOG.info("Alors dans la console, s'affiche 1+34=35");
	
	assertThat(systemOutRule.getLog()).contains("1+34=35");

	}
	
	
	@Test

	public void CalculException() throws Exception {

	LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression xxx");

	String expression = "xxx";
	when(calculService.additionner(expression)).thenThrow(new tp.exception.CalculException("L’expression "+expression+" est invalide."));

	LOG.info("Lorsque la méthode evaluer est invoquée");
	
	this.app.evaluer(expression);

	LOG.info("Alors le service est invoqué avec l'expression {}", expression);
	
	assertThat(systemOutRule.getLog()).contains("L’expression xxx est invalide.");

	

	}
	
	
	
	/**@Test
	
	public void demarrer() {
		app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****");
		
	}
*/
	
/**
	 @Rule
	  public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	 @Test
	
	public void demarrerfin() {
		 systemInMock.provideLines("fin");
		 app.demarrer();
		
		 String logConsole = systemOutRule.getLog();
		 assertThat(logConsole).contains("**** Application Calculatrice ****");
		 assertThat(logConsole).contains("Aurevoir :-(");
		
		
	}*/
	
	
	 
	 @Rule
	  public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	 @Test
	
	public void demarrerfin() {
		 systemInMock.provideLines("1+2");
		 systemInMock.provideLines("fin");
		 app.demarrer();
		
		 String logConsole = systemOutRule.getLog();
		 assertThat(logConsole).contains("**** Application Calculatrice ****");
		 assertThat(logConsole).contains("Veuillez saisir une expression:");
		 assertThat(logConsole).contains("1+2=3");
		 assertThat(logConsole).contains("Veuillez saisir une expression:");
		 assertThat(logConsole).contains("Aurevoir :-(");
		
		
	}
	
	 
	}
	

