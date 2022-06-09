import java.util.Scanner;
public class RectangleStat{
//This program asks for width and length of rectangle from user and calculates the area and perimeter
    public static void main (String[] args){
        double width, length, area, perimeter;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the precise width of the rectangle in inches: "); //input for width of rectangle from user
        width = keyboard.nextDouble();
        System.out.print("Enter the precise length of the rectangle in inches: "); //input for length of rectangle from user
        length = keyboard.nextDouble();
        area = width * length; //formula for area of rectangle
        perimeter = (width + length) * 2; //formula for perimeter of rectangle
        System.out.println("The area of your rectangle is " + area + " inches and the perimeter is " + perimeter + " inches.");
        keyboard.close();
    }
}
