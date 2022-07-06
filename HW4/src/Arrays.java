import java.time.*;

/*
This program prints elements of various types of arrays. First, it prints all elements of a standard integer array. Second, it prints all elements of a String array. Third, it prints
all elements of a 2d array and the number of rows & columns associated with this array. Finally, it prints the elements of a array of times
*/
public class Arrays{

  public static void main(String [] args) {
    String [] nth = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};  //Array of 10 string elements
    int [][] numbers = new int [10][20];  //Array of numbers with 10 rows and 20 columns
    LocalTime [] time = {LocalTime.of(8,20,30), LocalTime.of(19,45,59), LocalTime.of(23,59,22)}; //Array of 3 time elements

    basicArray();  //Print integers array
    System.out.println("\n");
    printElements(nth);  //Print String array
    System.out.println("\n");
    System.out.println("Rows: " + numbers.length);  //Number of rows in 2d array
    System.out.println("Columns: " + numbers[0].length);  //Number of columns in 2d array
    printElements(numbers);  //Print 2d array
    System.out.println();
    printElements(time);  //Print time array
  }

  //This method first takes no input. Then it makes an array object and stores the values of 1 through 50 for each element, then adds each element by 10. Finally, it prints each element of the array
  public static void basicArray(){
    int [] nums = new int [50];  //Make a new array containing 50 elements

    for (int i=1; i<=50; i++){
      nums[i-1] = i;
      nums[i-1] += 10;  //Add 10 to each element
      if (i == 50)
        System.out.print(nums[i-1]);  //If element is the last element in the array, print it
      else
        System.out.print(nums[i-1] + ", ");  //Else, print each element with a comma prior to it
    }
  }

  //This method takes an array of strings as input. It prints all the string elements in that array as output
  public static void printElements(String[] nth){
    for (int i=0; i<nth.length; i++){
      if(i==nth.length-1)
        System.out.print(nth[i]);  //If element is the last element in the array, print it
      else
        System.out.print(nth[i] + ", ");  //Else, print each other element with a comma prior to it
    }
  }

  //This method takes a 2d array of integers. It prints all the integer elements in the array in matrix form
  public static void printElements(int[][] numbers){
    for (int i=0; i < numbers.length; i++){
      for (int j=0; j < numbers[0].length; j++){
        System.out.printf("%d ", numbers[i][j]);  //Print each element in columns
      }
    System.out.println();  //Go to next row
    }
  }

  //This method takes a array of LocalTime objects and prints each element in that array, shown as time
  public static void printElements(LocalTime[] time){
    for (int i=0; i<time.length; i++){
      if(i==time.length-1)
        System.out.print(time[i]);  //If element is the last element in the array, print it
      else
        System.out.print(time[i] + ", ");  //Else, print each other element with a comma prior to it
    }
  }
}