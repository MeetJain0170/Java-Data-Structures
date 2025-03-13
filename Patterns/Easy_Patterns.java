public class Easy_Patterns {
    int n;
    int m;

    // Constructor to initialize the dimensions for patterns
    public Easy_Patterns(int n, int m){
        this.n = n;
        this.m = m;
    }

    // Method to print a filled rectangle of '*' with dimensions n x m
    public void Filled_Rectangle(){
        System.out.println("Rectangle with dimensions length " + n + " Breadth " + m + ":");
        System.out.println();
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                System.out.print("*"); // Printing '*' for each position in the rectangle
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }
    
    // Method to print a hollow rectangle where only the borders are filled with '*'
    public void Hollow_Rectangle(){
        System.out.println("Hollow Rectangle with dimensions length " + n + " Breadth " + m + ":");
        System.out.println();
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    System.out.print("*"); // Printing '*' for borders
                } else {
                    System.out.print(" "); // Printing space for non-border positions
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Method to print a right-angled triangle of '*' with height n
    public void Right_Triangle(){
        System.out.println("Here's A Right Angled Triangle with height " + n + ":");
        System.out.println();
        for(int i = 1; i <= this.n; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*"); // Printing '*' for each position in the current row
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Method to print an upside-down right-angled triangle of '*' with height n
    public void Upside_Down_Right_triangle(){
        System.out.println("Here's A Upside Down Right Angled Triangle with height " + n + ":");
        System.out.println();
        for(int i = this.n; i > 0; i--){
            for(int j = i; j > 0; j--){
                System.out.print("*"); // Printing '*' for each position in the current row
            }
            System.out.println(); // Move to the next line after each row
        }            
    }

    // Method to print an inverted right-angled triangle with spaces on the left and '*' on the right
    public void Inversed_Right_Triangle(){
        System.out.println("Here's A Inversed Right Angled Triangle with height " + n + ":");
        System.out.println();
        for(int i = 1; i <= this.n; i++){
            for(int j = 1; j <= this.n - i; j++){
                System.out.print(" "); // Printing spaces for left alignment
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*"); // Printing '*' for each position in the current row
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Method to print a right-angled number triangle with height n
    public void Number_Triangle(){
        System.out.println("Here's A Number Triangle with height " + n + ":");
        for(int i = 1; i <= this.n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " "); // Printing numbers incrementally in each row
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }

    // Method to print an inverted right-angled number triangle
    public void Inversed_Number_Triangle(){
        System.out.println("Here's A Number Triangle with height " + n + ":");
        for(int i = this.n; i >= 1; i--){
            for(int j = i; j >= 1; j--){
                System.out.print(j + " "); // Printing numbers in decreasing order
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }

    // Method to print an upside-down number triangle with numbers increasing from left to right
    public void UpsideDown_Number_Triangle(){
        System.out.println("Here's A Upside Down Number Triangle with height " + n + ":");
        for(int i = this.n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " "); // Printing numbers incrementally in each row
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }

    // Method to print a continuous number triangle starting from a specified number k
    public void Continuous_Number_Triangle(int k){
        System.out.println("Here's A Continuous Number Triangle with height " + n + ":");
        for(int i = 1; i <= this.n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(k + " "); // Printing continuous numbers starting from k
                k++; // Incrementing the number after each print
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }

    // Method to print a binary triangle pattern with alternating 1s and 0s
    public void Binary_Traingle(){
        System.out.println("Here's A Binary Number Triangle with height " + n + ":");
        for(int i = 1; i <= this.n; i++){
            for(int j = 1; j <= i; j++){
                int sum = i + j;
                if(sum % 2 == 0){
                    System.out.print(1); // Printing 1 if sum of indices is even
                } else {
                    System.out.print(0); // Printing 0 if sum of indices is odd
                }
            }
            System.out.println(); // Move to the next line after each row
        }
        System.out.println();
    }

    // Main method to create an object of Easy_Patterns class and call all the pattern methods
    public static void main(String[] args) {
        Easy_Patterns obj1 = new Easy_Patterns(5, 5); // Creating object with n = 5, m = 5
        obj1.Filled_Rectangle();
        obj1.Hollow_Rectangle();
        obj1.Right_Triangle();
        obj1.Upside_Down_Right_triangle();
        obj1.Inversed_Right_Triangle();
        obj1.Number_Triangle();
        obj1.Inversed_Number_Triangle();
        obj1.UpsideDown_Number_Triangle();
        obj1.Continuous_Number_Triangle(1);
        obj1.Binary_Traingle();
    }
}
