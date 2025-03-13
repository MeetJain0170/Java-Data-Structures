public class PathSum {
    public static  boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if(root.left == null && root.right == null && (sum - root.val) == 0){
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);               
    }

    public static void main(String[] args) {
        
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(20);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(7);

        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;

        System.out.println(hasPathSum(one,30));
    }
}
