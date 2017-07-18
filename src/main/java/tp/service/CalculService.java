package tp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.exception.CalculException;


public class CalculService {

public int additionner(String expression) {
	
// Ajouter un log en niveau DEBUG affichant "Evaluation de l'expression
	
 LoggerFactory.getLogger("tp.service").info(expression);
 int x = 0 ;
 int somme = 0;

 String table [] = expression.split("\\+");
 
 try {
	 
 while (x < table.length){
	
	 somme = somme + Integer.parseInt(table[x]);
	 ++x; 
 }
 
 LoggerFactory.getLogger("tp.service").info(expression+"="+somme);
 
 } catch (NumberFormatException e){
	 
	 throw new CalculException("L’expression "+expression+" est invalide.");
 }
 
return somme;

}

}
