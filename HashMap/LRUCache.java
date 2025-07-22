import java.util.*;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    
    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            deleteNode(temp);
            map.remove(key);
        }
        if(map.size() == capacity) {
            Node last= tail.prev;
            deleteNode(last);
            map.remove(last.key);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

    public void addNode(Node curr){
        Node temp = head.next;
        curr.next = temp;
        temp.prev = curr;
        head.next = curr;
        curr.prev = head;
    }

    public void deleteNode(Node curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr =map.get(key);
        deleteNode(curr);
        addNode(curr);  
        return curr.value;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the LRU Cache: ");
        int capacity = sc.nextInt();
        LRUCache lruCache = new LRUCache(capacity);

        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        System.out.println("Value for key 2: " + lruCache.get(2));
        lruCache.put(4, 40);
        System.out.println("Value for key 1: " + lruCache.get(1));
        lruCache.put(5, 50);
        System.out.println("Value for key 3: " + lruCache.get(3));
        System.out.println("Value for key 4: " + lruCache.get(4));
        System.out.println("Value for key 5: " + lruCache.get(5));
        lruCache.put(6, 60);

        sc.close();
    }   
}
