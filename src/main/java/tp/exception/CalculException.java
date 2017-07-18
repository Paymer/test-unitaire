package tp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.console.AppiTest;

public class CalculException extends RuntimeException {

	public CalculException() {
		super();
	}

	public CalculException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculException(String message) {
		super(message);
	}

	public CalculException(Throwable cause) {
		super(cause);
	}

	/*
	String x; 
	
	
	public CalculException(String message) {
		super.message=message;
		
	}
	*/
	
	

	
}
