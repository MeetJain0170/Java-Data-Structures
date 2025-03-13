public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
    }
    public static void main(String args[]){
        TreeNode p_one = new TreeNode(1);
        TreeNode p_two = new TreeNode(2);
        TreeNode p_three = new TreeNode(3);

        p_one.right = p_three;
        p_one.left = p_two;
        
        TreeNode q_one = new TreeNode(1);
        TreeNode q_two = new TreeNode(2);
        TreeNode q_three = new TreeNode(3);

        q_one.right = q_three;
        q_one.left = q_two;

        System.out.println(isSameTree(p_one,q_one));
    } 
}  
