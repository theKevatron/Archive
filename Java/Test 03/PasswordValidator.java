//PASSWORD VALIDATOR
//Checks whether a password is valid by checking if it contains at least eight characters, contains only letters and digits, and at least two digits.

//Import scanner to gather user input
import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) {
		//Import scanner to gather user input
		Scanner input = new Scanner(System.in);
		//Define user input
		System.out.print("Enter a password: ");
		//Store user input as variable "password"
		String password = input.nextLine();
		
		//Declare digits variables to be used to check for digits in password later
		int digits = 0;
		
		//If statement to check if the password is at least 8 characters long
		if (password.length() <= 7) {
			System.out.println("Invalid Password");
			System.exit(0);
		}

		//For loop to check each character in the password
		//checking to verify that all characters are either digits or letters
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				System.out.println("Invalid Password");
				System.exit(0);
			}
		}
		
		//For loop to check the password for digits
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				//Increment the digit counter each time a digit is found
				digits++;
			}
		}
		
		//If statement to check whether there was at least 2 digits in the password
		if (digits < 2) {
			System.out.println("Invalid Password");
			System.exit(0);
		}
		//If the password passed all tests, it is a valid password
		else
			System.out.println("Valid Password");
	}
		
}