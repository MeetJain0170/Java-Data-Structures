import java.util.*;
public class ValidStackSequence {
    public static boolean validateStackSequence(int[] popped, int[] pushed){
        if(pushed.length == 1){
            return pushed[0] == popped[0];
        }

        int popIndex=0;
        Stack<Integer> st = new Stack<>();

        for(int ele : pushed){
            st.push(ele);

            while(!st.isEmpty() && st.peek() == popped[popIndex]){
                st.pop();
                popIndex++;
            }
        }return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] popped ={1,2,3,4,5};
        int[] pushed ={4,5,1,2,3};

        System.out.println(validateStackSequence(pushed,popped));
    }
}
