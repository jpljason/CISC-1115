/*
This program takes in a month number, from 1 to 12, and a year number from the user using standard input and prints the number of days in that month based on the year using
the MonthDays class
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) throws MonthException{
    int month,year,numberOfDays;
    Scanner keyboard=new Scanner(System.in);

    System.out.print("Enter a month number(1-12): ");
    month=keyboard.nextInt();  //Takes month number from user
    System.out.print("Enter a year: ");
    year=keyboard.nextInt();  //Takes year number from user
    MonthDays days = new MonthDays(month,year);  //Create a MonthDays object and set the values of month and year in its constructor
    numberOfDays=days.getNumberOfDays();  //Call the getNumberOFDays method from the class
    System.out.printf("%s %04d has %d days\n", days.toString(),year,numberOfDays);  //Print the month's name,year and the number of days in that month
    keyboard.close();
  }
}