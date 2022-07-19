import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
/*
This program takes vehicle type(s), speed(mph), and time(hours) for that vehicle and prints a chart indicating the distance traveled(in miles) each hour by that vehicle
*/
public class Vehicle{

  public static void main(String[] args) throws Exception{
    String vehicle;
    double speed, time;
    File inputfile = new File("vehicleinputfile.txt");  //file to be used for input values
    Scanner input = new Scanner(inputfile);

    while(input.hasNextLine()){  //takes data from input file
      input.nextLine();
      vehicle=input.next();
      while(!input.hasNextDouble()){  //makes sure the Scanner takes in all the tokens of the vehicle's name if it has spaces
        vehicle+=" "+input.next();
      }
      speed=input.nextDouble();
      time=input.nextDouble();
      saveAsFile(vehicle+".txt",distance(speed,time*60),speed,vehicle);  //print report to a file
    }
    System.out.println("The program has successfully finished, output is file with vehicle name followed by \".txt\"(Ex: train.txt)");  //prints message to console telling user that program is successful and sent to file
    input.close();
  }

  //This method takes the speed(mph) and time(minutes) of a driving vehicle. It computes the distance traveled in total and returns this value
  public static double distance(double speed, double time){
    return speed * time / 60;
  }

  //This method takes a file name, as a String, distance traveled by the vehicle, speed of the vehicle, and the name of the vehicle, and then prints the full report of distance traveled each hour by the vehicle and prints to the a appropriate file
  public static void saveAsFile(String fileName, double distance, double speed, String vehicle)throws Exception{
    File outputfile = new File(fileName);
    PrintStream output = new PrintStream(outputfile);
    double distanceEachHour=0, time=distance/speed;
    int hourNumber;

    output.println("Distance each hour for a "+vehicle+":\n");
    if(speed>=0 && time>0){  //if speed and time are appropriate values
      output.printf("%s%28s\n","Hour","Distance Traveled(miles)");
      output.println("----------------------------------");
      for (hourNumber=1;hourNumber<=time;hourNumber++){  //print each hour followed by distance each hour
        distanceEachHour+=speed;  //distance each hour
        output.printf("%-5d%15.2f", hourNumber, distanceEachHour);
        output.println();
      }
      if(time%1!=0){  //if time is not a whole number, add an extra hour and compute the distance traveled in that hour
        output.printf("%-5d%15.2f",hourNumber,distanceEachHour+=time%1*speed);
        output.println();
      }
    }
    else if(speed<0 && time>0){  //if speed is invalid value but time is valid value, print appropriate message
      output.println("Invalid value for speed!");
    }
    else if(speed>=0 && time<=0){  //if speed is valid value but time is invalid value, print appropriate message
      output.println("Invalid value for time!");
    }
    else{  //if both speed and time is inappropriate values, print appropriate message
      output.println("Invalid values for time and speed!");
    }
    output.println();
    output.close();
  }
}