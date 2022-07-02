import java.util.Scanner;
import java.io.*;
/*
This program first scans and takes data from another file in the form of integers. It then
prints the factorial, sum of squares up to that integer, and the elements of the
Fibonacci Sequence counting up to the value of the integers
*/
public class Program1{

  public static void main (String[] args) throws Exception{
    int number;
    File inputfile = new File("inputfile.txt");
    Scanner input = new Scanner(inputfile);

    while (input.hasNext()){
      number = input.nextInt();
      printFactorial(number);
      System.out.println();
      printSumOfSquares(number);
      System.out.println();
      printFibonacci(number);
      System.out.println("\n");
    }
    input.close();
  }

  //This method takes the prompted integer as input and prints the factorials for the given integer
  public static void printFactorial(int n){
    if (n<0)
      System.out.print("Invalid number for factorial");  //Scenario where there is no possible factorial for the given integer
    else {  //if integer is not less than 0, finding factorial is possible
    System.out.print("The factorial of " + n + " is ");
    for (int i = n; i > 1 ; i--){
      System.out.print(i + " * ");  //prints each number of the factorial
    }
    System.out.print("1");  //last (or first) number of every possible factorial is always 1
    }
  }

  //This method takes the prompted integer as input and prints the sum of squares up to and ending at the integer
  public static void printSumOfSquares(int n){
    int sumOfSquares = 0;

    if (n<0)
      System.out.print("Invalid number for sum of squares");  //Scenario where sum of squares for this integer is impossible
    else {  //if integer is not less than 0, sum of squares is possible
    for (int i = 0; i <= n; i++){
      sumOfSquares += i*i;  //iteratively add the squares of each number until it reaches the prompted integer
    }
    System.out.print("The sum of squares up to and ending at " + n + " is " + sumOfSquares);
    }
  }

  //This method takes the prompted integer as input and prints the Fibonacci Sequence up to that nth element
  public static void printFibonacci(int n){
    int first = 1, second = 2;  //these two variables reference the two preceding numbers to be added, we start with 1 and 2 in this Fibonacci sequence
    int temp; //variable used to swap values

    if (n<=0)
      System.out.print("Invalid number for Fibonacci sequence");  //Scenario where Fibonacci sequence for this integer is impossible
    else if (n==1)
      System.out.print("The Fibonacci Sequence for the first element is 1");  //Scenario where the user prompts only the first element of the Fibonacci sequence
    else if (n==2)
      System.out.print("The Fibonacci Sequence for the first two elements is 1, 2");  //Scenario where the user prompts only the first two elements of the Fibonacci sequence
    else{
      System.out.print("The Fibonacci Sequence for the first " + n + " elements is 1, 2, ");
      for (int i = 3; i<=n; i++){
        if (i==n)
          System.out.print(first+second);  //if this is the last element in the sequence, print it without a comma
        else{
          System.out.print(first+second + ", ");  //else print each element followed by a comma until it reaches the last element
          temp = first+second;  //temporary variable to hold the value of the next element to add
          first=second;  //the first number swaps to the second
          second=temp;  //the second number swaps to the current element in the sequence
          //now it can find the next element of the sequence by adding these next two numbers
         }
       }
     }
   }
}