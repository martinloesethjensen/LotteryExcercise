import java.util.*; //for Scanner
import java.io.*;   //for Random

public class lotteryGameOpt3 {
   public static void main(String[] args) throws Exception {
      intro(); //Run intro 
      start(); //Start game
   }

   public static int[] userNumbers(Scanner console) throws Exception {
      Scanner inputUser = new Scanner(new File("lotto.dat")); //Scan users saved numbers
      int[] userNumberArray = new int[6]; //Create array for users numbers
      int numberInput = 1; //being used in option 3 (line 55)
      int k = 0; //being used in option 3 (line 41)
      
      line(); //Print a line
      System.out.print("\nEnter 1, 2 or 3 to either keep, generate or pick new numbers: ");
      String option = console.next(); //Get input from user
      System.out.print("");
      line(); //Print line
   
      if (option.equals("1")) { //If user chooses option 1, they keep their saved numbers
         System.out.println("\n>> Keeping numbers.");
         graphics(); //prints graphics     
         for (int i = 0; i < userNumberArray.length; i++) { //For loop repeat through the entire array (6 times)
            int userNumber = inputUser.nextInt();  //Read next int from lotto.dat and save it in the variable userNumber
            userNumberArray[i] = userNumber; //Insert usernumber into array at index i 
         }
         printNumbers(userNumberArray, false); //Print numbers and dont save the numbers to lotto.dat 
      } else if (option.equals("2")) { //If user chooses option 2, they generate new numbers
         System.out.println("\n>> Generating new numbers.");
         graphics(); //prints graphics
         userNumberArray = drawNumbers(false); //Draw new numbers without printing them and save the newly generated numbers into the userNumberArray
         printNumbers(userNumberArray, true);   //Print user numbers and save the new numbers to lotto.dat
      } else if (option.equals("3")){ //If user chooses option 3, They will pick new numbers themselves   
         System.out.println("\n>> Picking new numbers.");
         graphics(); //prints graphics
         
         System.out.print("\nChoose six numbers from 1-20.\n");
         do{
            for(k = 0; k < 6; k++){ //loops length of the array (6 times)     
               System.out.print("Type " + (k + 1) + " number: "); //prints text + the current number
               
               while(!console.hasNextInt() && console.hasNextLine()){ //see if user input is valid  
                  
                  System.out.print("This is not a valid input.\nPlease enter a number between 1-20.\n");
                  System.out.print("Type " + (k + 1) + " number: ");
                  if (console.hasNextLine() && console.hasNextInt()){
                     System.out.println(console);                          //work in progress --- fx (k 9) then it will run while loop, but also take in the int... and print   
                     k++;
                  }
                  console.next(); //very important. Lets user try again until he has a valid number 
                                                                                     
               }
               numberInput = console.nextInt(); //saves user input
               if(numberInput > 0 && numberInput < 21){// it runs because numberInput is 1.
                  userNumberArray[k] = numberInput; //saves number to array
               
               }
               
               for(int m = 0; m < k; m++){//see if there's any duplicates
                  if (userNumberArray[k] == userNumberArray[m]){ //if there are, then print a som text and let k go back one number
                     System.out.print("Please choose a number you don't already have.\n");
                     k--; //go one step back and re-generate a number
                  }
               }
               if(numberInput <= 0 || numberInput > 20){ //if the user input is under 0 or over 20 : go back  
                  System.out.println("Please type numbers from 1-20: ");
                  k--; //go one step back and re-generate a number
                  numberInput = 1; //to avoid infinity print of the text above 
               }           
            }
         
         }while(k < 6);
         graphics(); //Print loading graphic
         printNumbers(userNumberArray, true); //Print numbers and save the new numbers to lotto.dat
         
      }else{ //If the users enters anything else than option 1, 2 or 3 then start over and ask again
         System.out.println("\nOnly print numbers between 1-3");
         userNumbers(console); //Start over by running the userNumber method again
      }
      System.out.println(); //Skips line
      return userNumberArray; //Returns user numbers in array
   }

   public static int[] drawNumbers(Boolean print) throws Exception {
      Random drawNumber = new Random(); //Create random object
      int[] number = new int[6]; // Create array of 6 
      for (int i = 0; i < number.length; i++) { // Generate 6 random numbers 
         number[i] = drawNumber.nextInt(20) + 1; //Save generated number in the array at the given index  (1-20)
         for (int j = 0; j < i; j++) {
            if (number[i] == number[j]) //Check for duplicates 
               --i; // Go one step back and re-generate a number
         }     
      } 
      if (print == true) { //If print is true then print numbers
         System.out.print(">> Drawing numbers please wait.\n");
         graphics(); //Print loading graphic
         printNumbers(number, false); //Print numbers and dont save them to lotto.dat
      }
      return number; //return generated numbers in array
   }
   //compare users number with the drawed number
   public static void doCompare(int[] userNumber, int[] drawedNumber) throws Exception {
      int count = 0; //Counted hits
      System.out.println();
      for (int i = 0; i < userNumber.length; i++) { //two for loops used to compare the numbers in the 2 arrays
         for (int j = 0; j < drawedNumber.length; j++) {
            if (drawedNumber[i] == userNumber[j]) { //see if the users number is the same as the drawed number
               Thread.sleep(500); //wait 0.5 sec
               System.out.print(">> Winning numbers: ");
               Thread.sleep(1000); //wait 1 sec
               System.out.print(drawedNumber[i] + "\n"); //print the number that was the same "winning number"
               count++; // add to count
               
               
            }
         }
      }
      line();
      graphics(); //prints graphics
      System.out.printf("\nYou had %d out of 6 numbers!\n",count);
      winCheck(count);//check if you won
      
   }
   //check if you won 
   public static void winCheck(int count) {
      switch (count) { //got the count and sees if they match and of the cases, if not print default
         case 6: //6 hits
            System.out.println("You won the big jackpot!");
            line();
            break;
         case 5: //5 hits
            System.out.println("You won the medium jackpot!");
            line();
            break;
         case 4: //4 hits
            System.out.println("You won the small jackpot!");
            line();
            break;
         default: //les than 4 hits
            System.out.println("Bad luck, no jackpot for you this time.\nBetter luck next time!");
            break;
      }
   
   }

   public static void printNumbers(int[] numbers, boolean save) throws Exception {
      Arrays.sort(numbers); //Sort array (lowest to highest)
      System.out.println(); 
      for (int k = 0; k < numbers.length; k++) {
         Thread.sleep(1000); //1 second delay between printing the drawed numbers
         System.out.print(numbers[k] + " "); //Print drawed number one at a time
         if (save == true) { //if true save numbers
            saveNumbers(numbers);
         }
      }
      System.out.println();
      line();
   }
   //Save user numbers in lotto.dat 
   public static void saveNumbers(int[] numbers) throws Exception {
      PrintStream out = new PrintStream(new File("lotto.dat"));//if lotto.dat file doesn't exist, then it creates a new file called lotto.dat 
      for (int i = 0; i < 6; i++) {
         out.print(numbers[i] + " ");//print user numbers from array 
      }
     
   }
   //Graphics and load with 0.5 sec delay
   public static void graphics() throws Exception{
      load();
      line(); 
   }
   //Loading graphics (with timer 0.5 sec) 
   public static void load()throws Exception{
      System.out.print("\n                          loading ");
      for (int l = 0; l < 3; l++){//loop 3 times
         Thread.sleep(500);//half second
         System.out.print(".");
      }
      System.out.println();
   }
   //Graphics
   public static void line(){
      for(int line = 0; line <= 62; line++){
         System.out.print("_");
      }
      System.out.println();
   }
   public static void intro()throws Exception{
      //make a count so it can read different introes?
      line(); System.out.println();
      System.out.println("                 < Welcome to the lottery! > ");
      Thread.sleep(1000);
      System.out.println("               < Maybe it's your luck today? >");
      Thread.sleep(1000);
      for (int i = 0; i < 62; i++){
         System.out.print("_");
      }
      System.out.println(); load(); //Graphics
   }
   
   public static void playAgain(Scanner console)throws Exception{
      System.out.print("\n>> Would you like to play again? yes or no? ");
      String answer = console.next(); //initialize a string that holds value from the console
      answer = answer.toLowerCase(); //all characters to lower case
      if(answer.startsWith("y")){ //if string starts with y
         line();
         System.out.println("\n         < Hope you'll have better luck this time! >   \n");
         start(); //Start again
      } else {
         line();
         System.out.print("\n                   < Thanks for playing! >         \n");
         line();
      }
   }
   
   public static void start()throws Exception{
      Scanner console = new Scanner(System.in);
      int[] user = userNumbers(console); //initialize array from called method
      int[] lottoNumber = drawNumbers(true); //initialize array from called method : starts at true
      doCompare(user, lottoNumber); //call method with parametres
      playAgain(console);
   
   }
  
}