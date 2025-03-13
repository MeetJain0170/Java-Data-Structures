import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> result = new LinkedList<>();
		
		if (root==null) {
			return result;
		}   
		  
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;
		
		while (curr!=null || !st.isEmpty()) {
			while(curr!=null) {
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			result.add(curr.val);
			
			// traverse to the right nodes
			curr = curr.right;
		}
		
		return result;
    } 
	
	public static void main(String [] args) {
		TreeNode one = new TreeNode(3);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(20);
		TreeNode four = new TreeNode(15);
		TreeNode five = new TreeNode(7);
		
		one.left = two; 
		one.right = three;
		three.left = four;
		three.right = five;
		
		List<Integer> result = inorderTraversal(one);
		
		for(int ele:result) {
			System.out.print(ele+ " ");
		}
		
	}
}