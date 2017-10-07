/** Golf.java
 * Takes input from a file which contains names of golfers and
 * their scores per hole for 18 holes. Requires the number of golfers 
 * who participated in the round to be the first token in the .txt
 * Finally, outputs some information:
 *   1.  Average score of all golfers
 *   2.  Highest score amongst all golfers
 *   3.  Determines if any golfers scored a par or lower
 * 
 * @author Calvin Evans
 * @version 4/19/2017
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Golf {

    // Driver to compute golf scores
    public static void main(String[] args) {

        Scanner inputFile = null; // used for file containing data
        try {
            inputFile = new Scanner(new FileInputStream("golfScores.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found or not opened.");
            System.exit(0);
        }

        computeScores(inputFile);
    }

    // This methods detects the number of golfers, finds the name of the golfers,
    //sums the golfer's scores, determines how far above or below par the golfers were
    //and outputs this data to the console.
    /**
     * Method computeScores
     *
     * @param file A parameter
     */
    public static void computeScores(Scanner file) {
        int numGolfers = file.nextInt();
        System.out.println ("Number of golfers: " + numGolfers);
        System.out.println ("");
        System.out.println ("NAME\tSCORE\tTO PAR");
        System.out.println ("----\t-----\t------");

        double allScores = 0;
        boolean parScore = false;
        int highScore = 0;

        //calculates the golf scores and assigns the scores to the appropriate value
        //containers so they can be output (allScores= combined scores of all golfers, 
        //parScore= a tally of golfers that have scored at or below par, highScore= 
        //a running comparison check of the golfer with the highest total score
        while (file.hasNext ()) {
            String name = file.next ();
            System.out.print (name + "\t  ");
            int i = 0;
            int score = 0;
            for (i=1; i<=18; i++) {
                score += file.nextInt();

            }
            System.out.print (score + "\t   ");
            System.out.println (score - 72);
            allScores = allScores + score;
            if (score <= 72) {
                parScore = true;
            }
            if (score > highScore) {
                highScore = score;
            }
        }
        
        //outputs all of the collected statistical data about the golfer's scores to
        //the console
        System.out.println ("");
        System.out.println ("Average score: " + (allScores/numGolfers));
        System.out.println ("Highest score: " + highScore);
        
               if (parScore == true) {
            System.out.println ("At least one golfer scored par or below.");
        } else {
            System.out.println ("No golfers scored par or below.");
        }
        
    }

}