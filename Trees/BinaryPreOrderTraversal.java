import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryPreOrderTraversal{
    public static List<Integer> binaryPreOrderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();

        if(root == null){
            return result;
        }

        Stack <TreeNode> st = new Stack <>();
        TreeNode curr = root;

        while(curr != null){
            result.add(curr.val);
            if(curr.right != null){
                st.push(curr.right);
            }
            
            curr = curr.left;
            if(curr == null && !st.isEmpty()){
                curr = st.pop();
            }
        }return result;
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
		
		List<Integer> result = binaryPreOrderTraversal(one);
		
		for(int ele:result) {
			System.out.print(ele+ " ");
		}
		
	}
}
    