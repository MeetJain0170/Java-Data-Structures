public class RedBlackTrees {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static final class Node {
        int key;
        boolean color;     // RED or BLACK
        Node left, right, parent;
        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    // Single shared BLACK sentinel for all null children
    private final Node NIL = new Node(0, BLACK);
    private Node root = NIL;

    public RedBlackTrees() {
        NIL.left = NIL.right = NIL.parent = NIL;
    }

    /** Insert a key (duplicates ignored). O(log n). */
    public void insert(int key) {
        Node node = new Node(key, RED); // 20, R
        node.left = node.right = node.parent = NIL;

        Node parent = NIL;
        Node cur = root;

        // Standard BST descent
        while (cur != NIL) {
            parent = cur;
            if (key == cur.key) return;               // ignore duplicates
            cur = (key < cur.key) ? cur.left : cur.right;
        }

        // Link under parent
        node.parent = parent;
        
        if (parent == NIL) {
            // Empty tree: new node becomes root — make it BLACK explicitly
            root = node;
            node.color = BLACK;              // ← explicit node.color = BLACK
            return;
        } else if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        // Restore RB properties if parent was RED
        insertFixup(node);
    }

    /** RB insert fix-up (CLRS cases). */
    private void insertFixup(Node node) {
        while (node.parent.color == RED) {
            boolean parentIsLeft = (node.parent == node.parent.parent.left);
            Node grandparent = node.parent.parent;
            Node uncle = parentIsLeft ? grandparent.right : grandparent.left;

            if (uncle.color == RED) {
                // Case 1: parent & uncle RED → recolor & climb
                node.parent.color = BLACK;
                uncle.color = BLACK;
                grandparent.color = RED;
                node = grandparent;                   // climb up and continue
            } else {
                // Uncle BLACK: shape decides Case 2 then Case 3
                if (parentIsLeft && node == node.parent.right) {
                    // Left–Right (triangle) → rotate at parent to make it a line
                    node = node.parent;
                    rotateLeft(node);
                } else if (!parentIsLeft && node == node.parent.left) {
                    // Right–Left (triangle) → rotate at parent
                    node = node.parent;
                    rotateRight(node);
                }

                // Case 3 (line): rotate at grandparent, recolor
                node.parent.color = BLACK;            // new top of subtree
                grandparent.color = RED;              // pushed down
                if (parentIsLeft) {
                	rotateRight(grandparent);
                } else {
                	rotateLeft(grandparent);
                }
            }
        }
        // Always ensure root is BLACK
        root.color = BLACK;
    }

    // ---------- Rotations ----------
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == NIL)        root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else                         x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;

        x.parent = y.parent;
        if (y.parent == NIL) root = x;  // deletion of root
        else if (y == y.parent.left) y.parent.left = x;
        else y.parent.right = x;

        x.right = y;
        y.parent = x;
    }
}