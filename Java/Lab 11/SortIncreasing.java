//SORT INCREASING
//Prompts the user to enter five numbers, stores them in an array list, and sorts them into increasing order. 

//Import scanner and array list
import java.util.Scanner;
import java.util.ArrayList;

public class SortIncreasing {

	public static void main(String[] args) {
			//Declare integer array list
			ArrayList<Integer> numbers = new ArrayList<>();
			
			//Utilize scanner to gather user input
	        Scanner input = new Scanner(System.in);
	        System.out.print("Please enter 5 numbers: ");
	        
	        //For loop to gather 5 numbers using scanner
	        for (int i = 0; i <= 4; i++) 
	        {
	        	numbers.add(input.nextInt());
	        }
	        
	        //Call "sort" method
	        sort(numbers);
	        
	        //Display sorted list
	        System.out.println("Sorted list of numbers in increasing order:");
	        System.out.println(numbers);
	    }

		//Method to sort an array list
	    public static void sort(ArrayList<Integer> list) {
	        for (int i = 0; i < list.size() - 1; i++) {
	        	//Find the minimum in the list
	            int currentMin = list.get(i);
	            int currentMinIndex = i;
	            
	            for (int j = i + 1; j < list.size(); j++) {
	                if (currentMin > list.get(j)) {
	                    currentMin = list.get(j);
	                    currentMinIndex = j;
	                }
	            }
	            //Swap if necessary
	            if (currentMinIndex != i) {
	                list.set(currentMinIndex, list.get(i));
	                list.set(i, currentMin);
	            }
	        }
	    }
		
}