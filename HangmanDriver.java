/* This program is a word guessing game called hangman.
 * A person will try and guess a word before the max 
 * number of guesses are used. Every time the user chooses an 
 * incorrect letter another body part is displayed in the gallows.                           
 */

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HangmanDriver {

    public static final String filename = "hw7data.txt";

    // Driver to run the game using the student Hangman class
    public static void main(String[] args) {
        Scanner wordsFile = null;                  // words data file

        // open the file containing the words
        try {
            wordsFile = new Scanner(new FileInputStream(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found or not opened.");
            System.exit(0);
        }

        // create object and prepare to play game
        Hangman game = new Hangman(wordsFile);
        Scanner keyboard = new Scanner(System.in);

        // display an introduction on the game to the player
        game.displayGameIntro();

        // continually play new games if the user desires
        String playAgain;
        do {
            game.play();
            System.out.print("Do you want to play again? ");
            playAgain = keyboard.next();
            System.out.println();
        } while (playAgain.toUpperCase().startsWith("Y"));

        System.out.println("Thanks for playing!");
    }
}

