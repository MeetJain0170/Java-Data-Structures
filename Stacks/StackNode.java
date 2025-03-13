import java.util.Stack;

public class StackNode {
    public int val;
    public StackNode next;
    private StackNode head = null;
    
    public StackNode(){
    }
    public StackNode(int value, StackNode next){
        this.val = value;
        this.next = next;
    }
    public void push(int x){
        head= new StackNode(x, head);
    }
    public int pop(){
        int result = head.val;
        head = head.next;
        return result;
    }
    public static void main(String[] args) {
    	Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(3);
        st.push(2);
        int w = st.pop();
        System.out.println(w);
    }
}
