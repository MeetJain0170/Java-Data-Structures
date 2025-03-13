public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }
    public static void main(String args[]){

        TreeNode one = new TreeNode();
        one.val = 1;
        TreeNode two = new TreeNode();
        two.val = 2;
        TreeNode three = new TreeNode();
        three.val = 3;
        
        TreeNode four = new TreeNode(4);
        
        TreeNode five = new TreeNode(5);
        
        TreeNode six = new TreeNode(6);   

        TreeNode seven = new TreeNode(7);
    
        one.left=two;
        one.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;

        System.out.print("In-Order : ");
        inOrderTraversal(one);
        System.out.println();

        System.out.print("Pre-Order : ");
        inPreOrder(one);
        System.out.println();

        System.out.print("Post-Order : ");    
        inPostOrder(one);
        System.out.println();
    }
    public static void inOrderTraversal(TreeNode root){
        if (root == null){
            return;
        }
    inOrderTraversal(root.left);
    System.out.print(root.val);
    inOrderTraversal(root.right);

    }
    public static void inPreOrder(TreeNode root){
        if (root == null){
            return;
        }
    System.out.print(root.val);
    inPreOrder(root.left);
    inPreOrder(root.right);
    }
    public static void inPostOrder(TreeNode root){
        if (root == null){
            return;
        }
    inPostOrder(root.left);
    inPostOrder(root.right);
    System.out.print(root.val);
    }
}