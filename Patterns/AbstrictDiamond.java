import java.util.*;

public class AbstrictDiamond {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Rows: ");
            int rows = sc.nextInt();
            
            int upRows = rows / 2 + 1;
            
            // Upper part of the diamond
            for (int i = 0; i < upRows; i++) {
                for (int s = 0; s < upRows - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i * 2 + 1; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }

            // Lower part of the diamond
            int downRows = rows - upRows; 
            for (int r = 0; r < downRows; r++) {
                for (int s = 0; s <= r; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * (downRows - r) - 1; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}
