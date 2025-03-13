import java.util.*;

public class ValidParenthesis{
    public static boolean isValid(String s){
        Stack<Character> st =new Stack<>();

        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
        
            if((currentChar == '(' || currentChar =='[' || currentChar =='{')){
                st.push(currentChar);
        
            }else if(st.isEmpty()){
                return false;
        
            }else{
                Character top = st.peek();
        
                if((top == '[' && currentChar ==']') || (top == '{' && currentChar =='}')|| (top == '(' && currentChar ==')')){
                    st.pop();
        
                }else{
                    return false;
                }            
            }
        }return st.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("({[()]})"));
    }
}
