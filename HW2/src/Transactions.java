import java.util.Scanner;
import java.io.*;
public class Transactions{
    public static void main(String [] args) throws Exception {
      String date = "";
      int sku = 0, skuOfHighestPrice = 0, skuOfLowestPrice = 0;
      double price = 0, discount = 0, totalSum = 0, tax=0, highestPrice = 10000000, lowestPrice = 0;
      File inputfile = new File ("inputfile.txt");
      Scanner input = new Scanner(inputfile);
      PrintStream output = new PrintStream("outputfile.txt");
      while (input.hasNextLine()){
          date = input.next();
          sku = input.nextInt();
          price = input.nextDouble();
          discount = input.nextDouble();
          if (lowestPrice <= price - discount){
              lowestPrice = price - discount;
              skuOfLowestPrice = sku;
          }
          if (highestPrice >= price - discount){
              highestPrice = price - discount;
              skuOfHighestPrice = sku;
          }
          totalSum += price - discount;
          tax += totalSum * 0.08875;
      }
      output.println("Report from 04-01 to 04-29");
      output.printf("The total is $%.2f\n", totalSum);
      output.printf("The total tax is $%.2f\n", tax);
      output.printf("The highest price item is #%d at $%.2f\n", skuOfHighestPrice, highestPrice);
      output.printf("The lowest price item is #%d at $%.2f\n", skuOfLowestPrice, lowestPrice);
      System.out.println("Program complete");
      input.close();
      output.close();
    }
}
