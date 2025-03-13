public class ListNode{
	int val;
	ListNode next;
	public ListNode() {}
	public ListNode(int val) {
		this.val=val;
	}
	public static void printElement(ListNode head) {
		ListNode current=head;
		while(current != null){
			System.out.print(current.val+"->");
			current=current.next;
		}
		System.out.println("");
		}
	public static ListNode insertElementAtBeginning(ListNode head,int val) {
		ListNode newnode=new ListNode(val);
		newnode.next=head;
		return newnode;
	}
	public static void insertAtEnd(ListNode head,int val) {
		ListNode current=head;
		ListNode temp=new ListNode(val);
		while (current.next!=null) {
			current=current.next;
		}
		current.next=temp;
	}
	public static void insertAt(ListNode head, int index,int val){
		ListNode current=head;
		ListNode newnode =new ListNode(val);
		int count = 0;
		while (current != null){
			if (count == index-1){
				break;
			}
			current=current.next;
			count= count +1;
		}
		ListNode temp = current.next;
		current.next=newnode;                        
		newnode.next=temp;
	}	

	public static void UpdateElement(ListNode head, int Target, int New) {
		ListNode current = head;
		while (current != null){
			if (current.val == Target){
				current.val=New;
			}current=current.next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

        }   
        odd.next = evenHead;
        return head;

    }

	public static void main(String args[]) {
		ListNode one=new ListNode();
		one.val=1;
		ListNode head=one;
		ListNode two=new ListNode(2);
		one.next=two;	
		ListNode three=new ListNode();
		three.val=3;
		ListNode four=new ListNode(4);
		two.next=three;
		three.next=four;
		head=insertElementAtBeginning(head,0);
		printElement(head);
		insertAtEnd(head,23);
		printElement(head);
		
	}
}