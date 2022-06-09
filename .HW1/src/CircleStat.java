import java.util.Scanner;
public class CircleStat{
    public static void main (String [] args){
        double radius, circumference, area;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the radius of the circle in inches: ");
        radius = keyboard.nextDouble();
        circumference = radius * 2 * 3.14;
        area = 3.14 * radius * radius;
        System.out.printf("The circumference of your circle is %.3f inches and the area of your circle is %.3f inches."
        ,circumference, area);
        keyboard.close();
    }
}
