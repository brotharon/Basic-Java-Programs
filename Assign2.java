/** Assign2.java
 * Get four test scores from a user, then 
 * sort and print them in order from largest value to smallest value.
 * Output an error message if any test score is below 0 or above 100.
 * Finally, output some information (if there is no invalid score):
 *   1.  The average of the top three scores 
 *   2.  Whether the student passed (if the above average is at least 70)
 * 
 * @author Calvin Evans
 * @version 4/5/2017
 */

import java.util.Scanner;

public class Assign2 {

    public static final int SENTINEL = 0;        // sentinel value for user input

    // Driver to compute average scores and determine passing students
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            // User enters four numbers that represent a student's test scores.
            // If the user enters the sentinel four times, then the program exits.
            System.out.print("Enter four test scores: ");
            int test1 = keyboard.nextInt();
            int test2 = keyboard.nextInt();
            int test3 = keyboard.nextInt();
            int test4 = keyboard.nextInt();

            if (test1 == SENTINEL && test2 == SENTINEL && test3 == SENTINEL && test4 == SENTINEL) {
                shouldContinue = false;
            } else {
                computeScore(test1, test2, test3, test4);
            }
        }

    }

    /* Sorts input test scores, determines whether or not values are within range,
     * outputs descriptive error messages, outputs the scores after organizing from 
     * highest to lowest, calculates average of top 3 scores, outputs average, 
     * determines if score is passing or failing, outputs pass fail message
     */
    public static void computeScore(int test1, int test2, int test3, int test4) {
        //Compare values of scores (test1, test2, test3, test4) and organize them from
        // largest to smallestlargest in test1 and smallest in test4
        if (test1 < test2) {
            int temp = test1;
            test1 = test2;
            test2 = temp;
        }

        if (test3 < test4) {
            int temp = test3;
            test3 = test4;
            test4 = temp;
        }

        if (test1 < test3) {
            int temp = test1;
            test1 = test3;
            test3 = temp;  
        }

        if (test2 < test4) {
            int temp = test2;
            test2 = test4;
            test4 = temp;  
        }

        if (test2 < test3) {
            int temp = test2;
            test2 = test3;
            test3 = temp;  
        }

        //outputs error message if values larger and smaller than acceptable are 
        //entered
        if (test1 > 100 || test4 < 0) {
            System.out.println ("You must enter integer values between 1 and 100");
            if (test1 > 100 && test4 < 0) {
                System.out.print ("You have entered values that are too large ");
                System.out.println ("and too small.");
            } else if (test1 > 100) {
                System.out.println ("You have entered a value that is larger than 100");
            } else {
                System.out.println ("You have entered a value that is smaller than 0");
            }
        }

        //prints the test scores in order from largest to smallest
        if (test1 <= 100 && test4 >= 0) {
            System.out.print ("The test scores are: " + test1 + " " + test2 + " ");
            System.out.println (test3 + " " + test4);

            //drops the lowest test score and calculates the average of the remaining
            //scores.
            int avgScore = (test1 + test2 + test3)/3;
            System.out.print ("The average (after dropping the lowest) is: ");
            System.out.println (avgScore);

            //determines if the student has a passing grade on the test and outputs a 
            //pass/fail remark
            if (avgScore >= 70) {
                System.out.println ("That is a passing score.");
            } else {
                System.out.println ("That is not a passing score.");
            }
        }
        System.out.println ();
    }
}
