public class IsSymmetric {
    public static boolean Symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; 
        }
        if (left == null || right == null) {
            return false; 
        }
        return (left.val == right.val)
                && Symmetric(left.left, right.right)
                && Symmetric(left.right, right.left);
        }
    
        public static boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true; 
            }
            return Symmetric(root.left, root.right); 
        }
    public static void main(String[] args) {
      
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(9);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(15);

        one.left = two;
        one.right = three;
        three.left = four;
        two.right = five;

        System.out.println(isSymmetric(one));
    }
}
