public class Link_List {
    Link_List(){
        this.size = 0;
    }
    private int size;
    
    class Node{
        String data;
        Node next;
        
        Node (String data){
            this.data = data;
            this.next = null;
            size++;
            
        }
    }
    Node head;
    

    public void Add_First(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode; 
    }

    public void Add_Last(String data){
        Node newNode = new Node(data);
        Node current = head;
        if(head == null){
            head = newNode;
            return;
        }       
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

    }

    public void Delete_First(){
        if(head == null){
            return;
        }
        head = head.next; 
        size--;     
    }

    public void Delete_Last(){
        if(head == null){
            System.out.println("List Is Empty");
            return;
        }
        
        if(head.next == null){
            head = null;
            size--;
            return;
        }
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }current.next = null;
        size--;
        
    }

    public int GetSize(){
        System.out.println(size);
        return size;
        
    }

    public Node Reverse_List(){
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node previous = null;
        
        while(current != null){
            Node temporary = current.next;
            current.next = previous;
            previous = current;
            current = temporary;
        }
        head = previous;
        return head;     
    }

    public void Print_List(){
        Node current = head;
        if(current == null){
            System.out.println("There is no Link List");
            return;
        }
        while(current != null){
            System.out.print(current.data +" --> ");
            current = current.next;
        }System.out.println("Null");
    }

    public static void main(String[] args) {
        Link_List List = new Link_List();
        List.Add_First("Pirate");
        List.Add_First("the");
        List.Add_First("become");
        List.Add_First("will");
        List.Add_First("I");
        List.Add_First("Bro");
        List.Add_Last("King");
        List.Add_Last("Dattebayo");
        List.Print_List();

        List.Delete_First();
        List.Delete_Last();
        List.Print_List();

        List.Reverse_List();
        List.Print_List();
        List.GetSize();
        
    }
}
