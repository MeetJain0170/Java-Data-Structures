import java.util.*;
public class Two_Dimentional_Array {
    public static void main(String args[]){
        
        // Creating a scanner object to take input from the user
        try (Scanner sc = new Scanner(System.in)) {
        
            // Asking the user to input the number of rows of the matrix
            System.out.print("Enter number of rows of your matrix: ");
            int rows = sc.nextInt();
            
            // Asking the user to input the number of columns of the matrix
            System.out.print("Enter number of columns of your matrix: ");
            int cols = sc.nextInt();

            // Declaring a two-dimensional array (matrix) with specified rows and columns
            int[][] Array = new int[rows][cols];
            
            // Loop to input elements into the matrix row by row
            for(int i = 0; i < rows; i++){
                System.out.println("Enter your " + (i + 1) + " Row");
        
                // Input for each column element of the current row
                for(int j = 0; j < cols; j++){
                    Array[i][j] = sc.nextInt(); // Storing user input in the matrix
                }
            } 
            System.out.println();
            
            // Printing the matrix in its original form
            System.out.println("Your Matrix:");
            
            // Loop through each element to display the matrix
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    System.out.print(Array[i][j] + " "); // Printing each element
                }
                System.out.println(); // Move to the next row
            }
            System.out.println();

            // Asking the user to input a number to search in the matrix
            System.out.print("Enter the number you want to find in matrix: ");
            
            int x = sc.nextInt(); // The number to search for in the matrix
            System.out.println();

            // Loop to search the matrix for the given number
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    
                    // If the number is found, print its position (row and column)
                    if(Array[i][j] == x){
                        System.out.println("Your number x found at position row: " + (i + 1) + " ,Column: " + (j + 1) + ".");
                    
                        break; // Exit the loop once the number is found
                    }
                }
            }
        }
    }
}
