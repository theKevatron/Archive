//CUSTOM INTEGER CLASS
//This program defines a class to represent a specified integer.
//This Class contains: 
//An int data field named value
//A constructor that creates a MyInteger object for the specified int value
//A getter method that returns the int value
//The methods isEven(), isOdd(), and isPrime() that return true is the specified value is even, odd, or prime respectively
//The static methods isEven(int), isOdd(int), and isPrime(int) that return true is the specified value is even, odd, or prime respectively
//The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true is the specified value is even, odd, or prime respectively
//The methods equals(int) and equals(MyInteger) that return true if the value in this object is equal to the specified value
//A static method parseInt(char[]) that converts an array of numeric characters to an int value
//A static method parseInt(String) that converts a string into an int value

public class MyIntegerInstantiator{
	
	public static void main(String[] args) {
		//Declare objects of the MyInterger class and use MyInteger() constructor
		MyInteger object0 = new MyInteger(22);
		MyInteger object1 = new MyInteger(22);
		MyInteger object2 = new MyInteger(23);
		String object3 = "24";
		char[] object4 = {'1', '2'};
		//Using getValue() function
		System.out.println("Object 0 Value: " + object0.getValue());
		System.out.println("Object 1 Value: " + object1.getValue());
		System.out.println("Object 2 Value: " + object2.getValue());
		//Using isEven() functions
		System.out.println("Object 0 is even: " + object0.isEven());
		System.out.println("Object 1 is even: " + object1.isEven());
		System.out.println("Object 2 is even: " + object2.isEven());
		//Using isOdd() functions
		System.out.println("Object 0 is odd: " + object0.isOdd());
		System.out.println("Object 1 is odd: " + object1.isOdd());
		System.out.println("Object 2 is odd: " + object2.isOdd());
		//Using isPrime() functions
		System.out.println("Object 0 is prime: " + object0.isPrime());
		System.out.println("Object 1 is prime: " + object1.isPrime());
		System.out.println("Object 2 is prime: " + object2.isPrime());
		//Using equals() functions
		System.out.println("Object 1 is equal to 22: " + object1.equals(22));
		System.out.println("Object 1 is equal to Object 0: " + object1.equals(object0));
		//Using parseInt() functions
		System.out.println("Object 3: " + MyInteger.parseInt(object3));
		System.out.println("Object 4: " + MyInteger.parseInt(object4));	
	}
	
}

class MyInteger {
	
	//Declare attribute "value" for the MyInteger class
	private int value;
	//Constructor that sets specified value
	MyInteger(int newValue) {
		value = newValue;
	}
	//Method to get the value of "value" variable
	public int getValue() {
		return value;
	}
	//isEven() function to return "true" if the objects "value" is even
	public boolean isEven() {
		if ((value % 2) == 0)
			return true;
		else
			return false;
	}
	//isOdd() function to return "true" if the objects "value" is odd
	public boolean isOdd() {
		if ((value % 2) == 1)
			return true;
		else
			return false;
	}
	//isPrime() function to return "true" if the objects "value" is prime
	public boolean isPrime() {
		if (value == 2)
		{
			return true;
		}
		for (int i = 2; i <= value / 2; i++) {
			if (value % i == 0) 
			{
				return false; 
			}
		}
		return true; 
	}
	//isEven(int) static function to return "true" if the number entered is even
	public static boolean isEven(int tValue) {
		if ((tValue % 2) == 0)
			return true;
		else
			return false;
	}
	//isOdd(int) static function to return "true" if the number entered is odd
	public static boolean isOdd(int tValue) {
		if ((tValue % 2) == 1)
			return true;
		else
			return false;
	}
	//isPrime(int) static function to return "true" if the number entered is prime
	public static boolean isPrime(int tValue) {
		if (tValue == 2)
		{
			return true;
		}
		for (int i = 2; i <= tValue / 2; i++) {
			if (tValue % i == 0) 
			{
				return false; 
			}
		}
		return true; 
	}
	//isEven(MyInteger) static function to return "true" if the objects "value" is even
	public static boolean isEven(MyInteger oValue) {
		return oValue.isEven();
	}
	//isOdd(MyInteger) static function to return "true" if the objects "value" is odd
	public static boolean isOdd(MyInteger oValue) {
		return oValue.isOdd();
	}
	//isPrime(MyInteger) static function to return "true" if the objects "value" is prime
	public static boolean isPrime(MyInteger oValue) {
		return oValue.isPrime();
	}
	//equals(int) function to return "true" is the object's "value" is equal to the integer entered
	public boolean equals(int tValue) {
		if (value == tValue)
			return true;
		else
			return false;
	}
	
	//equals(int) function to return "true" is the both objects "value" attribute are the same value
	public boolean equals(MyInteger oValue) {
		if (oValue.value == this.value)
			return true;
		else
			return false;
	}
	//parseInt(char[]) function to convert a character array containing a numerical values into an integer
	public static int parseInt(char[] array) {
		int sValue = Integer.parseInt(new String(array));
		return sValue;
	}
	//parseInt(String) function to convert a string into an integer
	public static int parseInt(String string) {
		int sValue = Integer.parseInt(string);
		return sValue;
	}
	
}