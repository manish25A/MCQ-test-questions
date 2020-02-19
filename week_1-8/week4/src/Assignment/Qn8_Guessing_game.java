package Assignment;
import java.util.Random;
import java.util.Scanner;

public class Qn8_Guessing_game {

    public static void main(String[] args) {
        int guessednum,numToGuess,numOfTries=0;
        boolean win =false;
        Random rand=new Random();
        numToGuess=rand.nextInt(20000);
        Scanner input=new Scanner(System.in);


        while (win==false) {
            System.out.println("Guess  a number between 1 to 20000");
            guessednum=input.nextInt();
            numOfTries++;
            if(guessednum>20000 || guessednum<0) {
                System.out.println("You have choose over limit number");
            }
            else {
                if(guessednum == numToGuess) {
                    win=true;
                }
                else if(guessednum<numToGuess) {
                    System.out.println("Your number is less than the number");
                }
                else if(guessednum>numToGuess) {
                    System.out.println("Your number is greater than guessing number");
                }
            }
        }

        System.out.println("you got the number.");
        System.out.println("The number is " + numToGuess);
        System.out.println("It took "+ numOfTries +" tries fot you to guess.");

    }

}
