import java.util.*;

public class LL{
    public static void main(String[] args) {
        LinkedList<String> List = new LinkedList<String>();
        List.addFirst("is");
        List.addFirst("Kira");
        List.addLast("Justice");
        System.out.println(List);

        System.out.println(List.size());

        for(int i=0; i<List.size(); i++){
            System.out.print(List.get(i)+" -> ");
        }System.out.println("null");
        
        List.addFirst("Bro");
        List.removeFirst();
        System.out.println(List);
        
        List.add("Bro");
        List.removeLast();
        System.out.println(List);

        List.remove(1);
        System.out.println(List);
        List.add(1,"is");
        
        List.reversed();
        System.out.println(List);

    }
}
