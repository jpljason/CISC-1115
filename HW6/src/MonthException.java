/*
The class MonthException is custom exception class that is used when a month number or name is invalid
*/
public class MonthException extends Exception{  //This custom exception class is a subclass of the superclass Exception
  MonthException(String message){  //Constructor that takes in a String, in the form of a error message
    super(message);  //Call the constructor from the superclass, Exception
  }
}