import java.util.*;
public class ValidWordSubmission {
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'c'){
                if(st.size() >=2 && st.pop() == 'b' && st.pop() == 'a'){
                    // do  nothing //this it checks 'abc' could be removed or invalid word was given
                    //upon encountering 'c' -> if we do not have 'b' and  'a' to pop from the stack,
                    //in that order, then the given string was invalid.. it contained a permutation
                    // of 'abc' not 'abc'
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }return st.size() == 0;
    }
    public static void main(String[] args) {
        System.out.println(isValid("abcabcaabbcc"));
    }
}

