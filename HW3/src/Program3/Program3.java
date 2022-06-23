import java.util.Scanner;
import java.util.Date;
import java.io.*;
import java.text.*;
import java.time.*;
/*
This program reads in data from another file in the form of record dates. It compares these dates to the current date using various computations and prints the age of all
the records in the form of years,months and days.
*/
public class Program3 {

	public static void main(String[] args) throws Exception{
		int currentYear, currentDay, currentMonth;	//Variables to represent date of current date
		File inputfile = new File("inputfile.txt");	//File to be scanned for data
		Scanner input = new Scanner(inputfile);
		String [] dateArray = findCurrentDate();	//Find the current date and insert values
	  currentYear = Integer.parseInt(dateArray[0]);	//Assigning following variables according to their value of either year, month or day in the form of integers
	  currentMonth = Integer.parseInt(dateArray[1]);
	  currentDay = Integer.parseInt(dateArray[2]);
	  findAgeDifference(currentYear, currentMonth, currentDay, input);	//Find the age difference and print message
	  input.close();
	}
	public static void findAgeDifference(int currentYear, int currentMonth, int currentDay, Scanner input) {
		String recordDate;	//Variable to read in dates from file
		while (input.hasNext()) {
	    	input.next();	//Skip first word in the file
	    	recordDate = input.next();
	    	String [] array = recordDate.split("/");	//Split the date by year, month and day
	    	int recordYear, recordDay, recordMonth;		//Variables to represent the date of record
	    	recordYear = Integer.parseInt(array[0]);	//Converting elements to integers
	    	recordMonth = Integer.parseInt(array[1]);
	    	recordDay = Integer.parseInt(array[2]);
	    	LocalDate record_Date = LocalDate.of(recordYear, recordMonth, recordDay);	//Create LocalDate object to assign current date and record's date
	    	LocalDate currentDate = LocalDate.of(currentYear, currentMonth, currentDay);
	    	Period age = Period.between(record_Date, currentDate);	//Creating a Period object to find the time between the record date and current date
	    	if (age.getYears()<0 || age.getMonths()<0 || age.getDays()<0)	//If the record's date is ahead of the current date, it is an invalid date
	    		System.out.print("Invalid record date");
	    	else
	    		System.out.printf("The age of the record is %d years, %d months, and %d days old."	//If it's a valid date, print the age of the record
	    				, age.getYears(),age.getMonths(),age.getDays());
	    	System.out.println();	//skip a line
	    }
	}
	//Method used to find current date in the form of year/month/day, then splitting year, month and day into separate values and inserting into an array
	public static String [] findCurrentDate(){
		Date currentDate = new Date();
	  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");	//Format the date to year/month/day
	  String date = format.format(currentDate);
	  String [] dateArray = date.split("/");	//Split the values of the date
	  return dateArray;
	}
}