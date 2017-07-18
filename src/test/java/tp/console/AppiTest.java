package tp.console;

import tp.service.CalculService;

import org.junit.Before;

import org.junit.Rule;

import org.junit.Test;

import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppiTest {

	@Rule

	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private Appi app;

	private CalculService calculService;

	@Before

	public void setUp() throws Exception {

	this.calculService = new CalculService();

	this.app = new Appi(new Scanner(System.in), calculService);

	}

	@Test

	public void testAfficherTitre() throws Exception {

	this.app.afficherTitre();

	String logConsole = systemOutRule.getLog();

	assertThat(logConsole).contains("**** Application Calculatrice ****");

	}

	}
	

