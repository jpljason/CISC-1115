import java.util.Scanner;
import java.util.Date;
import java.io.*;
import java.text.*;
import java.time.*;
/*
This program takes input from a file in the form of record dates using Scanner class. It then compares these records' dates to the current date with various computations
and finally prints the age of the record in the form of a message
*/
public class Program3 {

	public static void main(String[] args) throws Exception{
		String recordDate;	//Variable used to assign value of date in file
		int currentYear, currentDay, currentMonth, recordYear, recordMonth, recordDay;	//Variables to represent date of current date
		File inputfile = new File("inputfile.txt");	//File to be scanned for data
		Scanner input = new Scanner(inputfile);

		String [] dateArray = findCurrentDate();	//Find the current date and insert value
		currentYear = Integer.parseInt(dateArray[0]);	//Assigning following variables according to their value of either year, month or day in the form of integer
		currentMonth = Integer.parseInt(dateArray[1]);
		currentDay = Integer.parseInt(dateArray[2]);
		while (input.hasNext()) {
			input.next();	//Skip first word in file
			recordDate = input.next();
	    		String [] array = recordDate.split("/");	//Split date into appropriate values
	    		recordYear = Integer.parseInt(array[0]);	//Converting elements to integers
	    		recordMonth = Integer.parseInt(array[1]);
	    		recordDay = Integer.parseInt(array[2]);
	    		findAgeDifference(currentYear, currentMonth, currentDay, recordYear, recordMonth, recordDay);	//Find age of record
		}
		input.close();
	}

	//This method takes the dates of the record and the current date and compares them to find the age of the record. It prints a message with this age
	public static void findAgeDifference(int currentYear, int currentMonth, int currentDay, int recordYear, int recordMonth, int recordDay) {
		YearMonth daysInMonth = YearMonth.of(recordYear, recordMonth);
		int days = daysInMonth.lengthOfMonth();	//method used to find the total amount of days in the record's month
		boolean validRecordDate = true;	//is the record's date valid?
		int yearDifference, monthDifference, dayDifference;	//variables for different in dates

		//if record date is ahead of current date, print invalid date
		if ((recordYear>=currentYear && recordMonth>currentMonth) || (recordYear>=currentYear && recordMonth>=currentMonth && recordDay>currentDay) || (recordYear > currentYear)) {
			System.out.println("Invalid record date");
			validRecordDate = false;
		}
		//if record's month is ahead of current month, add 12 to the current month and subtract 1 from the current year to compensate
		if (currentMonth<recordMonth) {
			currentMonth += 12;
			currentYear-=1;
		}
		//if record's day of the month is ahead of current day, add the total days during the record's month to the amount in current days and subtract 1 month from current month to compensate
		if (currentDay<recordDay){
			currentDay+=days;
			currentMonth-=1;
		}
		//if record's date is not invalid, do the computations and print out the age of record
		if (validRecordDate!=false) {
			yearDifference = currentYear - recordYear;
			monthDifference = currentMonth - recordMonth;
			dayDifference = currentDay - recordDay;
			System.out.printf("The age of the record is %d years, %d months, and %d days old", yearDifference, monthDifference, dayDifference);
			System.out.println();
		}
	}

	//Method used to find current date in the form of year/month/day, then splitting year, month and day into separate values and inserting into an array
	public static String [] findCurrentDate(){
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");	//Format the date to year/month/day
		String date = format.format(currentDate);
		String [] dateArray = date.split("/");	//Split values of date
		return dateArray;
	}
}
