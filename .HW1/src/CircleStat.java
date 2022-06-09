import java.util.Scanner;
public class CircleStat{
//This program asks the user for the radius of the circle and calculates the circumference and area
    public static void main (String [] args){
        double radius, circumference, area;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the radius of the circle in inches: "); //gets radius as input from the user
        radius = keyboard.nextDouble();
        circumference = radius * 2 * 3.14; //formula for circumference
        area = 3.14 * radius * radius; //formula for area
        System.out.printf("The circumference of your circle is %.3f inches and the area of your circle is %.3f inches."
        ,circumference, area); 
        keyboard.close();
    }
}
