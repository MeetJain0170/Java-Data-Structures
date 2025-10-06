
import java.util.HashMap;

class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache146 {
    HashMap<Integer, Node> map ;
    int cap;
    Node head;
    Node tail;

    public LRUCache146(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>(cap);
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key,int val) {

        if(map.containsKey(key)) {
            Node temp = map.get(key);
            deleteNode(temp);
        }

        if(map.size()==cap) {
            Node last = tail.prev;
            deleteNode(last);
            map.remove(last.key);
        }

        Node curr = new Node(key,val);
        addNode(curr);
        map.put(key, curr);
    }

    public void deleteNode(Node temp ) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void addNode(Node temp) {
        temp.next = head.next;
        head.next = temp;
        temp.next.prev = temp;
        temp.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key);
        deleteNode(curr);
        addNode(curr);
        return curr.val;
    }
    public static void main(String[] args) {
        LRUCache146 lru = new LRUCache146(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}















    
