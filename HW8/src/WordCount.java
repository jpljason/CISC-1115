import java.util.Scanner;
import java.io.File;
/*
This program takes a name of a text file from the command line argument and tracks how many words are in the file. Words are considered to have at least one number or letter in it
but consecutive symbols aren't considered words (Ex : ^^^ or &&& or ///). It prints out the total count of words in the form of a message.
*/
public class WordCount{
  public static void main(String[] args) throws Exception{
    File input = new File(args[0]);  //Taking file name from command line argument
    Scanner inputfile = new Scanner(input);
    int wordCount=0;  //Set initial word count to 0

    while(inputfile.hasNext()){
      wordCount+=words(inputfile);  //Adds up all the words in the file
    }
    System.out.println("There are " + wordCount + " words in this file!");
    inputfile.close();
  }
  /*This method takes a Scanner object as input and scans a token inside a file to figure out if it's a word.
  Any token with letters and numbers are considered words but consecutive symbols aren't considered words (Ex: *** or /// or ^^^).
  It returns a value of 1 if the token is considered a word and 0 if it isn't considered a word.
  */
  public static int words(Scanner inputfile){
    char[] words = {'a','b','c','d','e','f','g','h','i','j','k','l','m','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9'};  //Array of characters for words
    String token = inputfile.next();
    int count=0;
    boolean isWord=false;  //Assume token is not a word first

    for(int i=0; i<token.length(); i++){  //Searching
      for(int j=0; j<words.length; j++){
        if(Character.toLowerCase(token.charAt(i))==words[j]){  //If the token contains any letter or number,
          isWord=true;  //Token is a word
        }
      }
    }
    if(isWord==true){  //If token is a word,
      count++;  //Increase count by 1 to number of words
    }
    return count;
  }
}