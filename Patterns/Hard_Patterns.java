public class Hard_Patterns {
    int n;

    // Constructor to initialize the value of n for patterns
    public Hard_Patterns(int n){
        this.n = n;
    }

    // Method to print a butterfly pattern
    public void Butterfly(){
        System.out.println("Here's A Butterfly");
        System.out.println();
        
        // Upper half of the butterfly
        for(int i=1; i<=this.n; i++){
            for(int j=0; j<i; j++){
                System.out.print("*"); // Left side stars
            }
            for(int k=(this.n-i); k>0; k--){
                System.out.print(" "); // Left side spaces
            }
            for(int l=(this.n-i); l>0; l--){
                System.out.print(" "); // Right side spaces
            }
            for(int o=0; o<i; o++){
                System.out.print("*"); // Right side stars
            }
            System.out.println(); // Move to next row
        }
        
        // Lower half of the butterfly
        for(int i=this.n; i>=1; i--){    
            for(int j=i; j>0; j--){
                System.out.print("*"); // Left side stars
            }
            for(int k=0; k<(this.n-i); k++){
                System.out.print(" "); // Left side spaces
            }
            for(int l=0; l<(this.n-i); l++){
                System.out.print(" "); // Right side spaces
            }
            for(int o=i; o>0; o--){
                System.out.print("*"); // Right side stars
            }
            System.out.println(); // Move to next row
        }
    }

    // Method to print a parallelogram pattern
    public void Parallelogram(){
        System.out.println("Here's A Parallelogram");
        System.out.println();
        
        // Loop to print parallelogram
        for(int i=this.n; i>0; i--){
            for(int j=i; j>0; j--){
                System.out.print(" "); // Print leading spaces
            }
            for(int k=0; k<this.n; k++){
                System.out.print("*"); // Print stars for parallelogram
            }
            System.out.println(); // Move to next row
        }
        System.out.println();
    }

    // Method to print a number pyramid pattern
    public void Number_Pyramid(){
        System.out.println("Here's A Number Pyramid");
        System.out.println();
        
        // Loop to print number pyramid
        for(int i=1; i<=this.n; i++){
            for(int j=1; j<=(this.n-i); j++){
                System.out.print(" "); // Print leading spaces
            }
            for(int j=1; j<=i; j++){
                System.out.print(i + " "); // Print the row number as the number
            }
            System.out.println(); // Move to next row
        }
    }

    // Method to print a more complex number pyramid
    public void Harder_number_Pyramid(){
        System.out.println("Here's A Harder Number Pyramid");
        System.out.println();
        
        // Loop to print complex number pyramid
        for(int i=1; i<=this.n; i++){
            for(int j=this.n-i; j>0; j--){
                System.out.print(" "); // Print leading spaces
            }
            for(int k=i; k>=1; k--){
                System.out.print(k); // Print decreasing numbers
            }
            for(int l=2; l<=i; l++){
                System.out.print(l); // Print increasing numbers
            }
            System.out.println(); // Move to next row
        }
    }

    // Method to print a diamond pattern
    public void Diamond(){
        System.out.println("Here's A Diamond");
        System.out.println();
        
        // Upper half of the diamond
        for(int i=1; i<=this.n; i++){
            for(int j=this.n-i; j>0; j--){
                System.out.print(" "); // Print leading spaces
            }
            for(int k=i; k>=1; k--){
                System.out.print("*"); // Print left side stars
            }
            for(int l=2; l<=i; l++){
                System.out.print("*"); // Print right side stars
            }
            System.out.println(); // Move to next row
        }

        // Lower half of the diamond
        for(int i=this.n; i>=1; i--){
            for(int j=1; j<=this.n-i; j++){
                System.out.print(" "); // Print leading spaces
            }
            for(int k=1; k<=i; k++){
                System.out.print("*"); // Print left side stars
            }
            for(int l=i; l>=2; l--){
                System.out.print("*"); // Print right side stars
            }
            System.out.println(); // Move to next row
        }
    }

    // Main method to test and display all patterns
    public static void main(String[] args) {
        Hard_Patterns obj1 = new Hard_Patterns(10); // Create an object with n = 10
        obj1.Butterfly();
        obj1.Parallelogram();
        obj1.Number_Pyramid();
        obj1.Harder_number_Pyramid();
        obj1.Diamond();
    }
}
