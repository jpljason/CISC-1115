import java.util.Scanner;
/*
This program prompts the user to choose one of two shapes: circle or rectangle. Depending on the shape, it computes the perimeter or circumference
of the shape, and areas for both shapes.
*/
public class Program2{
  public static void main (String [] args) {
    String shape;
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Choose either a rectangle or a circle: "); //prompts the user to enter one of two shapes
    shape = keyboard.next();
    if (shape.equalsIgnoreCase("rectangle")){ //if user prompted rectangle, compute the perimeter and area
      double width, length, area, perimeter;
      System.out.print("Enter the length of this rectangle: "); //gets length as input from user
      length = keyboard.nextDouble();
      System.out.print("Enter the width of this rectangle: "); //gets width as input from user
      width = keyboard.nextDouble();
      perimeter = (width + length) * 2; //formula for perimeter of rectangle
      area = width * length; //formula for area of rectangle
      System.out.println("The area of your rectangle is " + area + " inches and the perimeter is " + perimeter + " inches.");
    }
    else if (shape.equalsIgnoreCase("circle")){ //else if user prompted circle, compute the circumference and area
      double radius, circumference, area;
      System.out.print("Enter the radius of the circle in inches: "); //gets radius as input from the user
      radius = keyboard.nextDouble();
      circumference = radius * 2 * 3.14; //formula for circumference
      area = 3.14 * radius * radius; //formula for area
      System.out.printf("The circumference of your circle is %.3f inches and the area of your circle is %.3f inches.\n"
      ,circumference, area);
    }
    else
      System.out.println("Invalid shape");  //if shape doesn't match description, tell the user it's invalid
    System.out.println(); //skip a line
    keyboard.close();
  }
}