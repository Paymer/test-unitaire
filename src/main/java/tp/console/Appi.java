package tp.console;

import tp.exception.CalculException;
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
	
		String expression;
		Scanner scanner = new Scanner(System.in);
		LoggerFactory.getLogger("tp.console").info("Veuillez saisir une expression:");
		expression = scanner.nextLine();
	while (!expression.equals("fin")){
		
		evaluer(expression);
		LoggerFactory.getLogger("tp.console").info("Veuillez saisir une expression:");
		expression = scanner.nextLine();
	}
		LoggerFactory.getLogger("tp.console").info("Aurevoir :-(");
	}

	protected void evaluer(String expression) {

		try {
			 
			int somme = calculatrice.additionner(expression);
			
			 LoggerFactory.getLogger("tp.console").info(String.valueOf(somme));
			 
			 } catch (CalculException e){
				 
				 LoggerFactory.getLogger("tp.console").info("L’expression "+expression+" est invalide.");
			 }
			 
		
	
	}
	
}
