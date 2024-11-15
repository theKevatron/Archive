//CELSIUS/FAHRENHEIT CONVERTER
//Converts celsius to fahrenheit(and vice versa). Displays results in a table with each value being displayed up to 2 decimal places.

//Import decimal format to limit decimal places printed
import java.text.DecimalFormat;

public class CelsiusFahrenheitConverter {
	
	public static void main(String[] args) {
		
		//Formatting to 2 decimal places
    	DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		//Print out table heading
        System.out.println("Celsius         Fahrenheit   |   Fahrenheit        Celsius     ");
        
        //Listing for 40-30 degrees celsius and 120-30 degrees fahrenheit
        //Incrementing by 1 for celsius and by 10 for fahrenheit
        for (int c = 40, f = 120; c >= 30 && f >= 30; c--, f -= 10) {
        	
        	//Variables to store values after they have been converted
        	double cF = celsiusToFahrenheit(c);
    		double fC = fahrenheitToCelsius(f);
    		
        	//Print out the values in a table format
			System.out.print(numberFormat.format(c) + "                " + numberFormat.format(cF));
			System.out.print("   |   ");
			System.out.println(numberFormat.format(f) + "               "+  numberFormat.format(fC));
		} 
	}
	
	//Method to convert celsius to fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        double f = (9.0 / 5) * celsius + 32;
        return f;
    }
	
    //Method to convert fahrenheit to celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        double c = (5.0 / 9) * (fahrenheit - 32);
        return c;
    }	
}