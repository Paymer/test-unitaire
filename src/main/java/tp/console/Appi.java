package tp.console;

import tp.service.CalculService;

import java.util.Scanner;

import org.slf4j.LoggerFactory;


public class Appi {

	private Scanner scanner;

	private CalculService calculatrice;

	public Appi (Scanner scanner, CalculService calculatrice) {

	this.scanner = scanner;

	this.calculatrice = calculatrice;

	}

	protected void afficherTitre() {

		 LoggerFactory.getLogger("tp.console").info("**** Application Calculatrice ****");
		
	}

	public void demarrer() {

	afficherTitre();

	}

	protected void evaluer(String expression) {

	}
	
}
