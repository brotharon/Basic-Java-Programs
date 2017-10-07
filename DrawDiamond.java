public class DrawDiamond {
    public static void main (String [] args) {
        final int SIZE = 20;
        makeDiamond (SIZE);
    }

    public static void makeDiamond(int size) {
        for (int row = 1; row <= size; row++) {
            for (int space = 0; space < size-row; space++) {
                System.out.print (" ");
            }
            System.out.print ("*");
            if (row > 1) {
                for (int spaces = 0; spaces < 2*row-3; spaces++) {
                    System.out.print (" ");
                }
                System.out.println ("*");
            } else {
                System.out.println ();                

            }
        }
        for (int row = 1; row < size; row++) {
            for (int spaces = 0; spaces < row; spaces++){
                System.out.print (" ");
            }
            System.out.print ("*");
            if (row < size - 1) {
                for (int spaces = 0; spaces < 2*size-2*row-3; spaces++) {
                    System.out.print (" ");
                }
                System.out.print ("*");

            }
            System.out.println ();
        }
    }
}
