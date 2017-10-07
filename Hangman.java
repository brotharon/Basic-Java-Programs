/** Hangman.java
 * Takes input file from hangman driver, parses out each word as the user plays,
 * converts the word to 2 separate arrays, compares user input against first array
 * if matching places value in second array, compares arrays to determine if they
 * match. 
 * 
 * @author Calvin Evans
 * @version 5/19/2017
 */

import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
    Scanner inputFile;
    String wordFile;
    char[] wordInput;
    char[] hiddenWord;
    boolean[] beenGuessed;
    
    public Hangman(Scanner file) {
        //stores the file input into an instance variable to be used by the class
        inputFile = file;
    }

    public void displayGameIntro() {
        // Outputs the introduction and rules to the game
        System.out.println ("Welcome to the hangperson game ...");
        System.out.println ("To play, guess a letter to try to guess the word.");
        System.out.println ("Every time you choose an incorrect letter another");
        System.out.println ("body part appears on the gallows. If you guess the");
        System.out.println ("word before you're hanged, you win :-)");
        System.out.println ("If you get hanged you lose :-(");
        System.out.println ();
        System.out.println ("Time to guess ...");
    }

    public void play () {
        Scanner keyboard = new Scanner(System.in);
        wordFile = inputFile.next().toLowerCase(); //get word from data file
        wordInput = wordFile.toCharArray(); //convert word to array of chars
        hiddenWord = new char[wordInput.length]; //initialize hidden letter array
        Arrays.fill (hiddenWord, '-');
        beenGuessed = new boolean[26]; // keeps track of letters that have been guessed
        boolean solved = false;
        int wrongGuesses = 0;

        while (wrongGuesses < 7 && solved != true) {
            System.out.println ("Choose a letter =>");
            System.out.println ();
            String guess = keyboard.next();
            char letter = checkInput(guess);
            int win = 0; //variable to keep track of matching chars
            if (letter != 0 && beenGuessed[letter - 'a'] != true) {
                int correctGuess = 0; //tracks instances of each guessed letter in word

                for (int i = 0; i < wordInput.length; i++) {
                    if (wordInput[i] == letter) {
                        correctGuess++;
                        //changes -'s to letters at i in hidden word array
                        hiddenWord[i] = letter; 
                        beenGuessed[letter - 'a'] = true;
                    } else {
                        beenGuessed[letter - 'a'] = true;
                    }
                }

                if (correctGuess == 0) {
                    //increments wrong guesses if no instance of guessed letter occur
                    wrongGuesses++;                     
                }

                buildGallows(wrongGuesses);
                System.out.println ();
                lettersGuessed(beenGuessed);
                System.out.println ("Number of wrong guesses => " + wrongGuesses);
                wordReveal(hiddenWord);
                System.out.println(); 

                for (int i = 0; i < hiddenWord.length; i++) {
                    if (hiddenWord[i] == wordInput[i]) {
                        //checks if all chars have been revealed
                        win++;
                    }
                }

                if (win == hiddenWord.length) {
                    //sets boolean winning parameter to true
                    solved = true;
                }

            }
        }
        //once play loop breaks out checks to see if game was won or lost
        //outputs win or loss state
        if (wrongGuesses == 7) {
            System.out.println ("Too bad, you lose!");
            System.out.println ("The word was ==> " + wordFile);
        } else {
            System.out.println ("Congratulations, you win!!!");
        }                       
    }

    public void wordReveal (char[] input) {
        //prints all -'s and revealed letters from hiddenWord array
        System.out.print ("The word so far => ");
        for (int i = 0; i < input.length; i++) {
            System.out.print (input[i]);
        }
        System.out.println();
    }

    public void lettersGuessed (boolean[] input) {
        //converts boolean array to chars and outputs to console
        System.out.print ("Letters guessed already => ");
        for (int i = 0; i < input.length; i++) {
            if (input[i]) {
                int temp = i + 'a';
                char toPrint = (char) temp;                
                System.out.print (toPrint + " ");
            }
        }
        System.out.println ();
    }

    public char checkInput (String input) {
        //validates user input before using in game, converts input to lower case,
        //determines if input was a letter, outputs error messages if not a letter
        //or if had been guessed already, returns letter if input is valid.
        String check = input.toLowerCase();
        char output = check.charAt(0);
        if (output < 'a' || output > 'z') {
            System.out.println ("You must guess a letter between a and z in the English ");
            System.out.println ("alphabet. Please try again!");
            System.out.println();
            return 0;
        } else if (beenGuessed[output - 'a']) {
            System.out.println ("This letter has already been guessed, try again");
            System.out.println();
            return 0;
        }
        return output;
    }

    public void buildGallows (int guesses) {
        //draws the person in the gallows depending on number of
        //inorrect guesses passed to method.
        System.out.println();
        System.out.println ("|-----|-");
        if (guesses == 0) {
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        } else if (guesses == 1) {
            System.out.println ("|     o");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        } else if (guesses == 2) {
            System.out.println ("|     o");
            System.out.println ("|     |");
            System.out.println ("|");
            System.out.println ("|");
        } else if (guesses == 3) {
            System.out.println ("|     o");
            System.out.println ("|     |");
            System.out.println ("|     |");
            System.out.println ("|");
        } else if (guesses == 4) {
            System.out.println ("|     o");
            System.out.println ("|    \\|");
            System.out.println ("|     |");
            System.out.println ("|");
        } else if (guesses == 5) {
            System.out.println ("|     o");
            System.out.println ("|    \\|/");
            System.out.println ("|     |");
            System.out.println ("|");
        } else if (guesses == 6) {
            System.out.println ("|     o");
            System.out.println ("|    \\|/");
            System.out.println ("|     |");
            System.out.println ("|    /");
        } else {
            System.out.println ("|     o");
            System.out.println ("|    \\|/");
            System.out.println ("|     |");
            System.out.println ("|    / \\");
        }
        System.out.println ("|__________");
    }
}
