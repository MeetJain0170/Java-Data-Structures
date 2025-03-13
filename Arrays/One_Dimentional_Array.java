import java.util.*;
public class One_Dimentional_Array {
    
    public static void main(){
        // Creating a scanner object to take input from the user
        try (Scanner sc = new Scanner(System.in)) {
            
            // Reading the size of the array from user input
            int size = sc.nextInt();
            
            // Declaring a one-dimensional array with the specified size
            int numbers[] = new int[size];

            // Loop to take input for each element of the array
            for(int i = 0; i < size; i++){
                numbers[i] = sc.nextInt(); // Filling the array with user inputs
            }

            // Reading the value of x, the number to search in the array
            int x = sc.nextInt();
            
            // Loop to traverse the array and find the element equal to x
            for(int i = 0; i  < numbers.length; i++){
                
                // If the element is found, print its index and exit the loop
                if(numbers[i] == x){
                    System.out.println("x found at index " + i);

                    // Exiting the loop once the element is found
                    break;                                      
                }                 
            }
        }      
    }
}
