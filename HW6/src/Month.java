/*
The class Month contains various methods such as converting a month number to its month name, converting a month name to its month number and determining whether two months are the same
*/
public class Month{
  int monthNumber;  //Instance variable for the month number

  Month(){  //Default constructor sets month number to 1
    this.monthNumber=1;
  }

  Month(int monthNumber){  //Constructor takes in an integer as input, in the form of a month number
    try{
      if(monthNumber>=1 && monthNumber<=12){  //If parameter's month number is greater or equal to 1 and less than or equal to 12, set the object's month number as this value
        this.monthNumber=monthNumber;
      }
      else{
        this.monthNumber=1;  //If it isn't, set the object's month number to 1
        throw new MonthException("Invalid month number entered, it is automatically set to the 1st month!");  //Throw a custom exception called MonthException
      }
    }catch(MonthException e){
      System.out.println("An error has occured"+e);  //Print a message of the error
    }
  }

  Month(String month) throws MonthException{  //Constructor that takes in a String as input in the form of the month's name
    String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};  //Array for all the month names
    boolean found=false;  //Boolean variable used to determine whether parameter value is a valid month

    for(int i=0;i<months.length;i++){  //Loops through the entire array of month names
      if(month.equalsIgnoreCase(months[i])){  //If the parameter's month is equal to a month in the array,
        this.monthNumber=i+1;  //Return the correct month number associated with this month name
        found=true;  //Valid month name
      }
    }
    if(found!=true){  //If it's not a valid month name,
      throw new MonthException("Invalid month name entered!");  //Throw a custom exception called MonthException
    }
  }

  public void setMonthNumber(int monthNumber){  //Method that takes in an integer, in the form of a month number, and sets the object's month number to that value
    if(monthNumber>=1 && monthNumber<=12){  //If parameter's month number is greater or equal to 1 and less than or equal to 12, set the object's month number as this value
      this.monthNumber=monthNumber;
    }
    else{  //Else, just set it to 1
      this.monthNumber=1;
    }
  }

  public int getMonthNumber(){  //Method that takes no input and returns the object's month number
    return this.monthNumber;
  }

  public String getMonthName(){  //Method that takes no input and returns the month's name based on its number
    switch(this.monthNumber){
      case 1: return "January";  //If object's month number is 1, return January
      case 2: return "February";  //If object's month number is 2, return February, etc...
      case 3: return "March";
      case 4: return "April";
      case 5: return "May";
      case 6: return "June";
      case 7: return "July";
      case 8: return "August";
      case 9: return "September";
      case 10: return "October";
      case 11: return "November";
      default: return "December";
    }
  }

  public String toString(){  //Method that takes no input and returns the same value as the getMonthName method
    return getMonthName();
  }

  public boolean equals(Month month){  //Method that takes in another Month object and determines whether they are the same or have the same values
    return(this.monthNumber==month.monthNumber);
  }
}