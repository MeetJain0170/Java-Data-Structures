import java.util.Stack;

public class Trie {
	
    private static class Node {
        Node[] next = new Node[26];
        int pass = 0;  // #words passing through this node
        int end  = 0;  // #words ending at this node
    }
    
    private final Node root = new Node(); // {Node,null, ....,25(null)}

    // "apple"
    // "app"
    // "bat"
    // Assumes 'a'..'z'. For other alphabets, we will have to use HashMaps
    public void insert(String word) {
        if (word == null) return;
        Node cur = root;
        cur.pass++;   
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);  // p
            
            int idx = c - 'a';  // 0 1 (b) 13 (p)
            if (cur.next[idx] == null) cur.next[idx] = new Node();  
            
            cur = cur.next[idx]; // b node
            cur.pass++;
        }
        cur.end++;
    }

    public boolean contains(String word) {
        Node n = walk(word);
        return n != null && n.end > 0;
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    
    // prefix app = 2
    // words that start with prefix
    public int countPrefix(String prefix) {
        Node n = walk(prefix);
        return n == null ? 0 : n.pass;
    }

    // Safe delete (only if word exists). Prunes dead branches.
    public boolean delete(String word) {
        if (!contains(word)) return false;

        Stack<Node> stack = new Stack<>();
        Stack<Integer> pathIdx = new Stack<>();
        
        Node cur = root;
        stack.push(cur);
        
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            cur = cur.next[idx];
            stack.push(cur);
            pathIdx.push(idx);
        }
        // decrement end at leaf
        cur.end--;

        // walk back: decrement pass and prune where pass hits 0
        for (int i = word.length(); i >= 0; i--) {
            Node node = stack.pop();
            node.pass--;
            if (i > 0) {
                Node parent = stack.peek();
                int idx = pathIdx.pop();
                if (node.pass == 0) parent.next[idx] = null; // prune
            }
        }
        return true;
    }

    // app
    private Node walk(String s) {
        if (s == null) return null;
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') return null;
            int idx = c - 'a';
            if (cur.next[idx] == null) return null;
            cur = cur.next[idx];
        }
        return cur;
    }
}