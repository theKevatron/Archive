//CUSTOM RECTANGLE CLASS
//This program defines a class to represent a rectangle.
//This Class contains: 
//Two double data fields named width and height, whose default values are 1
//A no-arg constructor that creates a default rectangle
//A constructor that creates a rectangle with the specified width and height
//A method named getArea() that returns the area of this rectangle
//A method named getPerimeter() that returns the perimeter of this rectangle

public class RectangleInstantiator{

	public static void main(String[] args) {
		//Creating object/instance of rectangle1
		Rectangle rectangle1 = new Rectangle(); 
		//Call getArea() method and getPerimeter() method and display
		System.out.println("The area of rectangle 1 is " + rectangle1.getArea() + ", and the perimeter is " +rectangle1.getPerimeter());
		
		//Creating object/instance of rectangle2 
		Rectangle rectangle2 = new Rectangle(2, 3);
		//Call getArea() method and getPerimeter() method and display
		System.out.println("The area of rectangle 2 is " + rectangle2.getArea() + ", and the perimeter is " +rectangle2.getPerimeter());
	}

}

//Rectangle Class
class Rectangle {
	//Two data fields of the rectangle class
	double width = 1;
	double height = 1;
	
	//Default/no-arg constructor
	//Constructs a rectangle with a width and height of 1
	Rectangle() {
		width = 1;
		height = 1;
	}
	
	//Constructs a rectangle with a specified width and height
	Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	//Method to get the area of the rectangle
	double getArea() {
		return width * height;
	}
	
	//Method to get the perimeter of the rectangle
	double getPerimeter() {
		return (width * 2) + (height * 2);
	}
	
}