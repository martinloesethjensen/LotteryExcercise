import java.io.*;
import java.util.*;

public class PrintStreamM {
   public static void main (String [] args) throws Exception{
   //User numbers of his choosing
   
      Scanner console = new Scanner(System.in);
      int[] number = new int[6];
      
      System.out.print("Choose six numbers from 1-20: "); //fencepost
      int numberInput = console.nextInt();
      for(int i = 0; i < 6; i++){//looping 6 times 
        
        number[i] = numberInput;
        if(i < 5){ //A limiter so it can only loop 5 times because we already have a fencepost 
           if(numberInput > 0 && numberInput < 20){
            System.out.print("Type next number: ");
            numberInput = console.nextInt();
            
           }else if (numberInput <= 0 || numberInput > 20){
            System.out.print("Please type numbers from 1-20: ");
            i--;
            numberInput = console.nextInt();
            } 
          /*  for(int j = 0; j < i; j++){ 
               if (number[i] == number[j]){// check for duplicates 
                  System.out.print("Please choose a number you don't already have: ");
                  i--; //go one step back and re-generate a number
                  numberInput = console.nextInt();
               }
            }*/   
        }
      }
         Arrays.sort(number);
         System.out.print(Arrays.toString(number));//print the users array 
         printStream(number, console);  
   }
   public static void printStream(int[] number, Scanner console)throws Exception{
      PrintStream output = new PrintStream(new File("NewLottoNumbers.dat"));
      for (int i = 0; i < number.length; i++){ 
      output.print(number[i] + " ");
      }
      
      System.out.println("\nYour numbers have now been saved.");
   }
} 