import java.util.Scanner;
import java.io.*;
/*
This program takes vehicle type(s), speed(mph), and time(hours) for that vehicle and prints a chart indicating the distance traveled(in miles) each hour by that vehicle
*/
public class Vehicle{

  public static void main(String[] args) throws Exception{
    String vehicle;
    double speed, time;
    File inputfile = new File("vehicleinputfile.txt");  //file to be used for input values
    Scanner input = new Scanner(inputfile);
    PrintStream output = new PrintStream("outputfile.txt");

    while(input.hasNextLine()){
      input.nextLine();
      vehicle=input.next();
      while(!input.hasNextDouble()){  //makes sure the Scanner takes in all the tokens of the vehicle's name if it has spaces
        vehicle+=" "+input.next();
      }
      speed=input.nextDouble();
      time=input.nextDouble();
      output.println("Distance each hour for a " + vehicle + ":\n");
      distance(speed,time*60, output);  //prints distance each hour chart
    }
    System.out.println("The program has successfully finished, output is generated to the file \"outputfile.txt\"");  //prints message to console telling user that program is successful
    input.close();
    output.close();
  }

  //This method takes the speed(mph) and time(minutes) of a driving vehicle. It computes the distance traveled each hour and the output is a chart indicating distance traveled each hour
  public static void distance(double speed, double time, PrintStream output){
    double hours=time/60;  //convert time from minutes to hours
    int hourNumber;
    double distance=0;

    output.printf("%s%28s\n","Hour","Distance Traveled(miles)");
    output.println("----------------------------------");
    for(hourNumber=1;hourNumber<hours;hourNumber++){  //loop for distance traveled each hour
      distance+=speed;  //distance traveled after each hour
      output.printf("%-5d%15.2f",hourNumber,distance);
      output.println();
    }
    if(time%60!=0){  //if hours traveled is not a whole number, add a extra hour to the chart and compute the extra distance traveled
      output.printf("%-5d%15.2f",hourNumber,distance+=time%60/60*speed);
      output.println();
    }
    output.println();
  }
}