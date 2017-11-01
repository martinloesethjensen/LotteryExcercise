# LotteryExcercise
A Lottery game.

Lotto
The program you are going to make now is simulating a Lotto drawing.
When it runs it will pick 6 random numbers and compare it to some user chosen numbers, and tell if and what is won.
You should work in groups of 2 or 3 (not more), and you should all code on your own computer.
You will hand the programs in on fronter, and we will look at you solutions in class during the next weeks. You have a week to do the assignment, and the class today is for doing this, you will not finish today so the rest is homework.
Game Plan

The following game plan comes in several parts. Complete one part at a time before going on to the next. And it is not mandatory to implement all parts in you final version, but do as many as you can.
Part 1 - Basic Program

In this part you will make the basic part of the program.
The user should have 6 numbers between 1 and 20 saved in a file called “lotto.dat”.
When the program runs, the users numbers are read from the file and printed to the console.
Then 6 random numbers between 1 and 20 is drawn, and printed to the console.
Your first job is to make a program that solved these 3 tasks.
It is a good idea to organise your code. So in the main method you should call the following methods:
userNumbers();
drawNumbers();
(these are methods made by you! ).
Both methods will probably have some parameters, but this is up to you to decide what kind.
Part 2 - Compare Numbers

Now you have the users numbers and the random Lotto numbers shown in the console.
In order to see if the user have any “win” numbers you need to add some additional functionality.
A way to do that would be to make a new method called doCompare() that is called from the drawNumbers method
userNumbers();
drawNumbers();
doCompare();
The responsibility of this method would be to compare 1 random lotto number at a time to all the numbers in the Lotto.dat file. If a “Hit” occurs the method should return true, and if not return false.
If it returns true you could save the number in a variable and then later print this variable out in the console.
Part 3 - Implement time delay

In 2nd semester you will learn about threads and learn how to handle Exceptions in you programs at runtime. But that does not mean that we can’t make use of it right now. Just accept that you will not get a deep explanation about it just yet.
One thing that could make your program a little more lively would be if we could delay the execution of certain parts of the code a bit.
Try to put this code part into the loop that picks the random lotto numbers. This will put a pause in between the printouts of the numbers by one second.
Thread.sleep(1000);
One thing you need to do is to make the method you are in ready for throwing an exception.
You already have this done somewhere with “throws FileNotFoundException”. Change this to
throws Exception  (and put it on all you methods as well)
Exception is a more general exception which include all exceptions also the FileNotFoundException.
Part 4

Now it would be nice to implement a method that checks if the user won anything.
When you made the method that compares the numbers in Part 2, you also printed out the numbers in the console.
Somehow you now have to count these numbers and if this count value is 6 you won the big jackpot, if 5 the medium jackpot, and so on.
The list of methods in your program now should look like this:
userNumbers();
drawNumbers();
doCompare();
winCheck();
Part 5 - New user numbers

So fare you didn’t do much in your userNumbers() method. But know you should add some additional functionality to this method.
Instead of just reading from the file Lotto.dat, you should give the user an option to create new numbers, or to keep on using the saved ones.
If he chooses to get new ones, you should either create 6 random numbers and write them to the file Lotto.dat, or give the user the option to write 6 numbers himself in the console and save these in the Lotto.dat file. After that the numbers in the file should be printed in the console, as you did so far.
Part 6 - Repeating numbers flaw (difficult)

One problem with your program is that the random Lotto numbers sometimes repeat so you could end up with two number 19 (etc.) in a draw. You have to eliminate this flaw in the program.
Part 7 - Make the program “Nice”

Make a nice intro text that describes the game with a headline and maybe some “graphics” (text symbols).
Make the numbers and text aligned by using printf() instead of print.
Look through your code and see if any parts of your code could be put in a method of its own. Here the rule of thumb is that if you have duplicate or identical code somewhere in your program, it could probably be put in a method of its own.
Part 8 - Improvise

Now you are finnished with the assignment, but if you have time please improve the program as you wish.
