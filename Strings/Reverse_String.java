public class Reverse_String {
    public static void main(String args[]){
        // Creating a String to alter
        StringBuilder sb = new StringBuilder("Hello"); 

        // Running it for half length only since we are switching characters position from first to last
        // so only half switches are required to achieve reverse order
        for(int i = 0; i < sb.length() / 2; i++){ 
            
            int front = i;                          // Position of the current character from the start of the string 
            int back = sb.length() - i - 1;         // Position of the corresponding character from the end of the string

            // Get the characters at the front and back positions
            char frontChar = sb.charAt(front); 
            char backChar = sb.charAt(back);

            // Swap the characters at the front and back positions
            sb.setCharAt(front, backChar); 
            sb.setCharAt(back, frontChar);
            
        }

        // Print the reversed string
        System.out.println(sb);
    }
}
