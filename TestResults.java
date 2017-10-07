/** TestResults.java
 * Takes input from a file. Parses out name of student and a number of test scores. Drops 
 * the lowest test score from the total, averages the remaining scores, compares average
 * against a passing score of 70 and outputs a chart with student name/ avg score/ pass
 * or fail.
 * 
 * @author Calvin Evans
 * @version 5/03/2017
 */

import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;

// Opens a file of test scores and calls processScores to read and evaluate them.
public class TestResults {
    public final static String filename = "testScores.txt";

    // Driver to open test file and call student-written method to process scores.
    public static void main(String[] args) {
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("File could not be opened: " + filename);
            System.exit(0);
        }

        processScores(inputFile);
    }

    // Takes input file from main method and parses out required information
    public static void processScores(Scanner file) {
        DecimalFormat df = new DecimalFormat("00.0");	// For outputing test average
        System.out.println("Name           Avg  Pass");
        System.out.println("------------------------");

        int numScores = 0; //running tally of number of test scores used for average
        int lowScore = 100; //keeps track of lowest score by student
        int scoresTotal = 0; //sums the total of all scores per student
        int nameLength = 0; //stores length of student's name for formatting use
        int currentScore = 0; //current score used for comparison against lowScore
        int scoreOutsideRange = 0; //used for error checking

        while (file.hasNext()) {
            String name = file.next();
            //shortens name to 14 characters so that a super long name does not
            //mess up the formatting
            name = name.substring(0, Math.min(name.length(), 14));
            nameLength = name.length();
            System.out.print (name);
            for (int i = 0; i <= 15 - (nameLength + 1); i++) {
                System.out.print (" ");
            }
            while (file.hasNextInt()) {
                currentScore = file.nextInt();
                if (currentScore >= 0 && currentScore <= 100) { 
                    numScores++;
                    scoresTotal += currentScore;
                    if (currentScore < lowScore) {
                        lowScore = currentScore;
                    }
                } else {
                    scoreOutsideRange++;
                }
            }
            //System.out.print (lowScore + " "); used to test outputs
            int dropLowest = scoresTotal - lowScore;
            double averageScore = (double) dropLowest / (numScores - 1);
            //the following was done to fix formatting for the possibility that a 
            //student could score a 100% on all tests. 
            if (averageScore >= 100.0) {
                System.out.print (df.format(averageScore) + " ");
            } else {
                System.out.print (df.format(averageScore) + "  ");
            }
            if (averageScore >= 70.0) {
                System.out.print ("Yes");
                //the following is used to error check entered values and format
                //for the "Yes" value.
                if (scoreOutsideRange > 0) {
                    System.out.print (" One or more scores were not used due to ");
                    System.out.println ("being outside of the expected 0-100 range.");
                } else {
                    System.out.println ();
                }
            } else {
                System.out.print ("No");
                //the following is used to error check entered values and format
                //for the "No" value.
                if (scoreOutsideRange > 0) {
                    System.out.print ("  One or more scores were not used due to ");
                    System.out.println ("being outside of the expected 0-100 range.");
                } else {
                    System.out.println ();
                }
            }
            
            //the following resets all required values to base so next student test
            //data can be calculated
            numScores = 0;
            lowScore = 100;
            scoresTotal = 0;
            scoreOutsideRange = 0;
        }
    }
}