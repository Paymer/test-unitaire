package tp.console;


import tp.service.CalculService;
import java.util.Scanner;

public class AppLauncher {

	public static void main(String[] args) {

	try (Scanner scanner = new Scanner(System.in)) {

	new Appi(scanner, new CalculService()).demarrer();

	}

	}

	
	
}
