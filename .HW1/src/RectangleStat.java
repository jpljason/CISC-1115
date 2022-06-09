import java.util.Scanner;
public class RectangleStat{
    public static void main (String[] args){
        double width, length, area, perimeter;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the precise width of the rectangle in inches: ");
        width = keyboard.nextDouble();
        System.out.print("Enter the precise length of the rectangle in inches: ");
        length = keyboard.nextDouble();
        area = width * length;
        perimeter = (width + length) * 2;
        System.out.println("The area of your rectangle is " + area + " inches and the perimeter is " + perimeter + " inches.");
        keyboard.close();
    }
}
