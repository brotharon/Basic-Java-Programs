/** Rocket.java
 * Take input from the main method and use this as the size parameter to construct
 * a rocket ship. All calculations are based off of the size input, so a positive 
 * integer size is required to draw a rocket. Size 0 or lower will only draw 2 columns
 * of X's. When tested with sizes > 1000 this took a long time to draw a rocket. 
 * 
 * @author Calvin Evans
 * @version 5/01/2017
 */
public class Rocket {

    public static void main(String[] args) {

        drawRocket(10);

    }

    public static void drawRocket(int size) {
        displayCone(size); // display rocket nose
        separatorLine (size); // display separator between nose and 1st section
        firstSection (size); // display top of upper main body section of rocket
        secondSection (size); // display bottom of upper main body section of rocket
        separatorLine (size); // display separator between 1st and 2nd sections
        secondSection (size); // display top of lower main body section of rocket
        firstSection (size); // display bottom of lower main body section of rocket
        separatorLine (size); // display separator between 2nd section and tail cone
        displayCone(size); // display rocket tail cone
    }
    // draws that cones that make up the nose section and tail cone section of the 
    // rocket based on size input from main method
    public static void displayCone (int size) {
        for (int row = 1; row <= 2*size-1; row++) {
            for (int space = 0; space < 2*size-row; space++) {
                System.out.print (" ");
            }
            for (int fSlash = 0; fSlash < row; fSlash++) {
                System.out.print ("/");
            }
            System.out.print ("**");
            for (int bSlash = 0; bSlash < row; bSlash++) {
                System.out.print ("\\");
            }
            System.out.println ();
        }

    }
    // draws the line that separates the sections of the rocket based on size input from
    // main method
    public static void separatorLine (int size) {
        System.out.print ("+");
        for (int row = 1; row <= size*2; row++) {
            System.out.print ("=*");
        }
        System.out.println ("+");
    }
    // draws the part of the center sections of the rocket where the triangles are
    // pointing upwards. Calculations based on size input.
    public static void firstSection (int size) {
        for (int row = 0; row < size; row++) {
            System.out.print ("|");
            for (int leftDots = 0; leftDots < size-row-1; leftDots++) {
                System.out.print (".");
            }
            for (int leftDiamond = 0; leftDiamond < row+1; leftDiamond++) {
                System.out.print ("/\\");
            }
            for (int middleDots = 0; middleDots < size*2-row*2-2; middleDots++) {
                System.out.print (".");
            }
            for (int rightDiamond = 0; rightDiamond < row+1; rightDiamond++) {
                System.out.print ("/\\");
            }
            for (int rightDots = 0; rightDots < size-row-1; rightDots++) {
                System.out.print (".");
            }
            System.out.println ("|");
        }
    }
    // draws the parts of the center sections of the rocket where the triangles are
    //pointing downwards. Calculations based on size input.
    public static void secondSection (int size) {
        for (int row = 0; row < size; row++) {
            System.out.print ("|");
            for (int leftDots = 0; leftDots < row; leftDots++) {
                System.out.print (".");
            }
            for (int leftDiamond = 0; leftDiamond < size-row; leftDiamond++) {
                System.out.print ("\\/");
            }
            for (int middleDots = 0; middleDots < row*2; middleDots++) {
                System.out.print (".");
            }
            for (int rightDiamond = 0; rightDiamond < size-row; rightDiamond++) {
                System.out.print ("\\/");
            }
            for (int rightDots = 0; rightDots < row; rightDots++) {
                System.out.print (".");
            }
            System.out.println ("|");
        }
    }
}