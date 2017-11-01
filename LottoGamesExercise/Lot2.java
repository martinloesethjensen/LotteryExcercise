import java.util.*;
import java.io.*;

public class Lot2 {
   public static void main (String[]args){
      //type six numbers between 1-20
      
      //if above 20 type a new int
      Scanner console = new Scanner(System.in);
      int[] number = new int[6];
      
     System.out.print("Choose six numbers from 1-20.\n");
         int numberInput = 1;
         for(int k = 0; k < 6; k++){
            if(numberInput > 0 && numberInput < 21){
               System.out.print("Type " + (k + 1) + " number: ");
               numberInput = console.nextInt();
               number[k] = numberInput;
            }
            for(int m = 0; m < k; m++){
               if (number[k] == number[m]){
                  System.out.print("Please choose a number you don't already have.\n");
                  k--; //go one step back and re-generate a number
               }
            }
            if(numberInput <= 0 || numberInput > 20){
               System.out.println("Please type numbers from 1-20: ");
               k--;
               numberInput = 1;   
            } 
         }
     System.out.print(Arrays.toString(number));

   }
}
