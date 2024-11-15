//ERROR HANDLING
//Causes the JVM to throw an OutOfMemoryError, then catches and handles it by displaying an error message. 
//We then print outside of the "try/catch" methods to verify the system continues running.

public class ErrorHandling {

	public static void main(String[] args) {
		
		//Throw OutOfMemoryError()
		try {
			
			throw new OutOfMemoryError();
		}
		
		//Catch OutOfMemoryError exception
		catch (OutOfMemoryError ex) {
			System.out.println("Out of memory error occurred ");
		}
		
		//Verify System continues
		System.out.println("System continuing");
	}

}