import java.util.Scanner;
/*
This program asks the user for a simple mathematical expression consisting of a first number, followed by a operator, followed by a second number, and computes the answer of the expression in the form of a message.
It keeps asking the user for another expression until the user enters "Done".
*/
public class Calculator{
  public static void main(String[] args){
    String expression;  //variable for the entire expression
    Scanner keyboard=new Scanner(System.in);

    System.out.print("Enter the math expression(Number followed by operator followed by number): ");
    expression=keyboard.nextLine().replaceAll("\\s","");  //assign expression and remove any spaces
    while(!expression.equalsIgnoreCase("done")){  //while expression is not sentinel value ("done")
      boolean invalidExpression=false;  //variable to determine whether expression is valid
      double firstNumber=0, secondNumber=0, answer=0;  //variables for first number of expression, second number of expression and answer of expression
      char[] operators={'*','+','-','/'};  //store all avaliable operators in an array
      char operator='0';  //variable for operator in the expression

      for(int i=0; i<operators.length; i++){  //search to see if a valid operator is in the expression
        if(expression.indexOf(operators[i])!=-1){  //if there is a valid operator in expression,
          invalidExpression=false;  //set invalid expression to false
          int index=expression.indexOf(operators[i]);  //find index of operator in the string expression
          operator=operators[i];  //set variable to the value of operator
          try{
            firstNumber=Double.parseDouble(expression.substring(0,index));  //find first number in the expression and assign
            secondNumber=Double.parseDouble(expression.substring(index+1));  //find second number in the expression and assign
          }catch(Exception e){
            invalidExpression=true;  //if values entered are not doubles, set invalid expression to true
          }
          break;  //break if operator is found
        }
        invalidExpression=true;  //if not found, set invalid expression to true
      }
      if(invalidExpression!=true){  //if expression is valid,
        answer=calculate(firstNumber,secondNumber,operator);  //find the answer of expression
        System.out.printf("The answer is %.3f\n", answer);
      }
      else{
        System.out.println("Invalid expression!");  //else, tell the user it is an invalid expression
      }
      System.out.print("Enter the math expression(Number followed by operator followed by number): ");  //go back to beginning of loop
      expression=keyboard.nextLine().replaceAll("\\s","");
    }
    System.out.println("Program halted!");  //tell user the program is finished after they enter "done" for the expression
    keyboard.close();
  }
  /*This method takes two doubles, a first number in an expression and a second number in an expression, and a operator in the form of a char. It then returns the appropriate calculation, in the form of a double value,
  based on the type of operator in the expression
  */
  public static double calculate(double firstNumber, double secondNumber, char operator){
    switch(operator){
      case '*': return firstNumber*secondNumber;
      case '+': return firstNumber+secondNumber;
      case '-': return firstNumber-secondNumber;
      default: return firstNumber/secondNumber;
    }
  }
}