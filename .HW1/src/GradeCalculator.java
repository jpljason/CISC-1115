import java.util.Scanner;
public class GradeCalculator {
    public static void main (String [] args){
        int homeWork, codeLab, midTerm_1, midTerm_2, finalGrade, totalGrade;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Out of 100, enter the percentage you scored on the homework (Don't include the % sign): ");
        homeWork = keyboard.nextInt();
        System.out.print("Now enter the percentage on the codelab (Don't include the % sign): ");
        codeLab = keyboard.nextInt();
        System.out.print("Do the same for midterm1 (Don't include the % sign): ");
        midTerm_1 = keyboard.nextInt();
        System.out.print("Your 2nd midterm (Don't include the % sign): ");
        midTerm_2 = keyboard.nextInt();
        System.out.print("Lastly, your percentage on the final (Don't include the % sign): ");
        finalGrade = keyboard.nextInt();
        totalGrade = (int)(homeWork * 0.15 + codeLab * 0.10 + midTerm_1 * 0.20 + midTerm_2 * 0.20 + finalGrade * 0.35);
        System.out.println("Your total grade for the class is " + totalGrade + "%");
        keyboard.close();
    }
}
