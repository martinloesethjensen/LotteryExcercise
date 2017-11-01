import java.util.*;
import java.io.*;

public class Lot {
   public static void main (String[]args){
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
         System.out.print(Arrays.toString(number));//print the users array
   }
}

/*
Something to add: 
- a scanner that reads the input and sees if input is other than an int
- option to keep using the previous numbers ()
*/