public class BinarySearchTree {
    static TreeNode root;
    private void insert(int val){
        
        root = insertRecord(root,val);            
        
    }

    private TreeNode insertRecord(TreeNode node, int val){

        if(node == null){
            node = new TreeNode(val);
            return node;
        } 
        
        if(val <= node.val){
            node.left = insertRecord(node.left, val);
        }else{
            node.right = insertRecord(node.right,val);
        }
        return node;
    }

    public boolean search(TreeNode root, int val){
        // we are searching for the leaf node so if the tree is empty it wont work
        if(root == null){
            return false;
        }
        
        // Traverse in the tree
        if(root != null && root.val == val){
            return true;
        }
        
        // if search node smaller than root then search left else right
        if(val <= root.val){
            return search(root.left, val);
        }else {
            return search(root.right, val);
        }

    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        
        BinarySearchTree obj = new BinarySearchTree();
        obj.insert(8);
        obj.insert(3);
        obj.insert(10);
        obj.insert(1);
        obj.insert(6);
        obj.insert(4);
        obj.insert(7);
        obj.insert(14);
        obj.insert(13);

        obj.inOrder(root);
        System.out.println();
        System.out.println(obj.search(root, 1));
    }
}
