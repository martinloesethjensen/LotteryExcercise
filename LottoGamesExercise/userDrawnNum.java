import java.util.*;
import java.io.*;

public class userDrawnNum{
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      int[] userNumberArray = new int[6];
      int numberInput = 1; //being used in option 3 (line XX)
      int k = 0; //being used in option 3 (line XX) 
      
      System.out.print("Choose six numbers from 1-20.\n");
      do{
      for(k = 0; k < 6; k++){ //loops length of the array (6 times)
         
            System.out.print("Type " + (k + 1) + " number: "); //prints text + the current number
            while(!console.hasNextInt()){
               System.out.print("This is not a valid input.\nPlease enter a number between 1-20.\n");
               System.out.print("Type " + (k + 1) + " number: "); //prints text + the current number
               console.next();
            }

            if(numberInput > 0 && numberInput < 21){// it runs because numberInput is 1.
            numberInput = console.nextInt(); //saves user input
            userNumberArray[k] = numberInput; //saves number to array
   
            }
            
            for(int m = 0; m < k; m++){//see if there's any duplicates
               if (userNumberArray[k] == userNumberArray[m]){ //if there are, then print a som text and let k go back one number
                  System.out.print("Please choose a number you don't already have.\n");
                  k--; //go one step back and re-generate a number
               }
               if(numberInput <= 0 || numberInput > 20){ //if the user input is under 0 or over 20 : go back  
                  System.out.println("Please type numbers from 1-20: ");
                  k--; //go one step back and re-generate a number
                  numberInput = 1; //to avoid infinity print of the text above    
               }
            }          
         }
      
      }while(k < 6);
         //load(); //Print loading graphic
         //printNumbers(userNumberArray, true); //Print numbers and save the new numbers to lotto.dat
   }
} 