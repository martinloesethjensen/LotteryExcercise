import java.util.*; //for scanner
import java.io.*; //for printstream and files

public class LottoGame {
   public static void main (String [] args) throws Exception{
      int play = 0;
      play(play);
           
   }
   public static void play(int play)throws Exception{
      if (play == 0){
         intro();
         int[] user = userNumbers();
         drawNumbers(true, user, play);
         play++;
      }else if (play > 0){
         System.out.println("\n\nWould you like to try again? \ty/n: ");
         Scanner console = new Scanner(System.in);
         //char inputChar = console.nextLine().nextChar();
         /*if (input.nextChar('y')){
            System.out.println("nice");
         }else{
            System.out.println("    --- See you next time ---");1
            brreak;
         }*/
         
      }
         
   }
   public static int[] userNumbers()throws Exception{
      /*Scanner inputUser = new Scanner(new File("lotto.dat"));  
      int[] userNumberArray = new int[6]; //user numbers in an array
      for(int i = 0; i < 6; i++){
         int userNumber = inputUser.nextInt();
         userNumberArray[i] = userNumber; //insert userNumber into array
         System.out.print(userNumber + " ");
      }
      Arrays.sort(userNumberArray); //sort usernumbers in the array
      System.out.println(); //skips line
      */
      
     //User numbers of his choosing
     Scanner console = new Scanner(System.in);
     int[] userNumberArray = new int[6]; //user numbers in an array 
     
     System.out.print("Choose six numbers from 1-20: "); //fencepost
     int numberInput = console.nextInt();
     for(int i = 0; i < 6; i++){//looping 6 times 
       userNumberArray[i] = numberInput;
       if(i < 5){ //A limiter so it can only loop 5 times because we already have a fencepost 
          if(numberInput > 0 && numberInput < 20){
           System.out.print("Type next number: ");
           numberInput = console.nextInt();
           
          }else if (numberInput <= 0 || numberInput > 20){
           System.out.print("Please type numbers from 1-20: ");
           i--;
           numberInput = console.nextInt();
       } 
       
       }
     }
     System.out.print("These are your numbers: " + Arrays.toString(userNumberArray)+ "\n\n");//print the users array
     return userNumberArray;
   }
   public static void drawNumbers(boolean print, int[] user, int play) throws Exception{
      //pick 6 random numbers from 1-20
      Random drawNumber = new Random();
      int[] number = new int[6]; //create array of 6
      for(int i = 0; i < 6; i++){ //generate 6 random numbers
         number[i] = drawNumber.nextInt(20)+1; //numbers from 1-20 saved in an array        
         for(int j = 0; j < i; j++){ 
            if (number[i] == number[j]){// check for duplicates 
               i--; //go one step back and re-generate a number
            }
         }  
      }
      for (int k = 0; k < number.length; k++){
         if (print == true){
            Arrays.sort(number);
            if (k == 0){ //Before the first number is drawn. Some graphics are shown on the console. 
               System.out.print("Drawing numbers ");
               load(); //load icon
            }
           // Thread.sleep(1500);
            System.out.print(number[k]+" ");
      }
      }
      doCompare(user, number, play);
   }
   public static int doCompare(int[] userNumber, int[] drawedNumber, int play)throws Exception{
      int count = 0;
      
      for(int i = 0; i < userNumber.length; i++){
         for(int j = 0; j < drawedNumber.length; j++){
         
            if(drawedNumber[i] == userNumber[j]){
               if (count == 0){
               System.out.print("\nYou got a hit on number "+ userNumber[j]);
               }if (count > 0){ 
               System.out.print(", " + userNumber[j]);
                  if(i + 1 == userNumber.length){
                  System.out.print(" and " + userNumber[j] + ".");
                  }
               }else if (count > 0 && j + 1 == userNumber.length){ 
               System.out.print(" and " + userNumber[j] + ".");
               }
            count++;  
            }
            /*if (count == 0 && drawedNumber[i] != userNumber[j]){
               System.out.println("\nHow unfortunate. You didn't get a hit on " + userNumber[j]);
               noHit++;
               if (noHit > 0){
               System.out.println(" and " + userNumber[j]);
               }
            }else if (count > 0 && drawedNumber[i] != userNumber[j]){
                  
            
            }*/
         }   
      } 
      if (count == 0){
         System.out.println("\n\nHow unfortunate.\nYou didn't get any hits.\nBetter luck next time."); 
      }
      play++;
      play(play);
      return play; 
   }
   public static void intro()throws Exception{
      //maybe a loop to make some graphics?
      //make a count so it can read different introes?
      System.out.println("  --- Welcome to the lottery! ---");
         Thread.sleep(1000);
      System.out.println("--- Maybe it's your luck today? ---");
         Thread.sleep(1000);
      load();
      System.out.println();
   }
   public static void load()throws Exception{
      for (int l = 0; l < 3; l++){//loop 3 times
         Thread.sleep(500);//half second
         System.out.print(".");
      }
      System.out.println();
   }
}