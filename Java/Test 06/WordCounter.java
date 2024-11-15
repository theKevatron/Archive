//WORD COUNTER
//Counts the number of words in specified text

//Import scanner to gather user input
import java.util.Scanner; 

public class WordCounter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter some text to find out how many words are in it: ");
		String text = scan.nextLine();
		
		char[] cText = text.toCharArray();
		int words = 0;
	    int i = 0;
		
	    if (Character.isLetter(cText[0]))
	    {
	        words++;
	    }
		
	    for (i = 1; i < text.length(); i++)
	    {
	        //Increments "words" if an alphabetic character is found
	        //and the index behind it is not an alphabetical character
	        if (Character.isLetter(cText[i]) && (!Character.isLetter(cText[i - 1])))
	        {
	            words++;
	        }
	    }
		
	    System.out.println("There are " + words + " words in this text.");
	}
	
}