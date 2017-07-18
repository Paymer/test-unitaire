package tp.exception;

import org.slf4j.LoggerFactory;

public class CalculException extends RuntimeException {

	String x; 

	public CalculException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CalculException(String message, Throwable cause) {
		super(message, cause);
		
		// TODO Auto-generated constructor stub
	}
	public CalculException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public CalculException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
