/*
The class MonthDays is a subclass of the superclass Month. It's main function is to calculate the number of days in a month, taking into account of leap years
*/
public class MonthDays extends Month{
  int year;  //Instance variable for the year

  MonthDays(int monthNumber, int year){  //Constructor that takes in 2 integers, in the form of a month number and a year, and sets the object's month number and year to these values
    super(monthNumber);
    this.year=year;
  }

  public int getNumberOfDays(){  //Method that takes no input and returns the number of days in a month and calculates for leap years as well
    if(this.monthNumber==1){
      return 31;
    }
    else if(this.year%100==0&&this.year%400==0&&this.monthNumber==2){  //If year is divisible by 100 and 400, it is a leap year
      return 29;
    }
    else if(this.year%100!=0&&this.year%4==0&&this.monthNumber==2){  //If year is not divisible by 100 but it is divisible by 4, it is a leap year
      return 29;
    }
    else if(this.monthNumber==2){
      return 28;
    }
    else if(this.monthNumber==3){
      return 31;
    }
    else if(this.monthNumber==4){
      return 30;
    }
    else if(this.monthNumber==5){
      return 31;
    }
    else if(this.monthNumber==6){
      return 30;
    }
    else if(this.monthNumber==7){
      return 31;
    }
    else if(this.monthNumber==8){
      return 31;
    }
    else if(this.monthNumber==9){
      return 30;
    }
    else if(this.monthNumber==10){
      return 31;
    }
    else if(this.monthNumber==11){
      return 30;
    }
    else{
      return 31;
    }
  }
}