import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findPaths(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> res) {
        if (root == null) return;

        currentPath.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(currentPath));
        } else {
            findPaths(root.left, sum - root.val, currentPath, res);
            findPaths(root.right, sum - root.val, currentPath, res);
        }

        currentPath.remove(currentPath.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, null, new TreeNode(1)))
        );

        int targetSum = 22;
        PathSum2 ps = new PathSum2();
        List<List<Integer>> paths = ps.pathSum(root, targetSum);

        if (paths.isEmpty()) {
            System.out.println("No paths found for sum = " + targetSum);
        } else {
            System.out.println("Paths summing to " + targetSum + ":");
            for (List<Integer> path : paths) {
                System.out.println(path);
            }
        }
    }
}
