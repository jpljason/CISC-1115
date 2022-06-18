import java.util.Scanner;
import java.io.*;
public class Transactions{
/*This program gathers data from transactions. Data includes date, SKU of item, price and discount of various items. It then does
 some various computations to calculate the total sum, tax, highest priced item and lowest priced item.
*/
    public static void main(String [] args) throws Exception {
      String startDate = "", endDate = "";
      int sku = 0, skuOfHighestPrice = 0, skuOfLowestPrice = 0;
      double price = 0, discount = 0, totalSum = 0, tax=0, highestPrice = 0, lowestPrice = 10000000;
      File inputfile = new File ("inputfile.txt");
      Scanner input = new Scanner(inputfile); //Used for reading SKU, price and discount of items from another file
      Scanner dates = new Scanner(inputfile); //Used for reading dates of these items from the same file
      PrintStream output = new PrintStream("outputfile.txt");
      dates.nextLine(); //skip the title of the file
      startDate = dates.next(); //find the start date
      dates.nextLine();
      while (dates.hasNextLine()){
          endDate = dates.next(); //find the end date
          dates.nextLine();
      }
      input.nextLine(); //skip the title of the file
      while (input.hasNextLine()){
          input.next();
          sku = input.nextInt();
          price = input.nextDouble();
          discount = price * input.nextDouble() / 100;
          if (lowestPrice >= price - discount){ //algorithm to find the lowest priced item
              lowestPrice = price - discount; //price of this item
              skuOfLowestPrice = sku; //sku of this item
          }
          if (highestPrice <= price - discount){ //algorithm to find the highest priced item
              highestPrice = price - discount; //price of this item
              skuOfHighestPrice = sku; //sku of this item
          }
          totalSum += price - discount; //algorithm to find the total amount after discounts
          tax = totalSum * 0.08875; //algorithm to find the amount for tax
      }
      output.println("Report from " + startDate + " to " + endDate);
      output.printf("The total is $%.2f\n", totalSum);
      output.printf("The total tax is $%.2f\n", tax);
      output.printf("The highest price item is #%d at $%.2f\n", skuOfHighestPrice, highestPrice);
      output.printf("The lowest price item is #%d at $%.2f\n", skuOfLowestPrice, lowestPrice);
      System.out.println("Program complete, data sent to outputfile.txt"); //Shows the program has successfully finished in the console
      input.close();
      output.close();
      dates.close();
    }
}
