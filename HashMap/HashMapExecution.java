import java.util.*;
import java.util.Map.Entry;

public class HashMapExecution {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();

        hm.put("Hello",1);
        hm.put("Hi",2);
        hm.put("World",3);

        System.out.println(hm);
        
        //Traversal on HashMap using entrySet()
        for(Entry<String, Integer>ele: hm.entrySet()){
            System.out.println("Key: "+ele.getKey() + " -> Value: "+ele.getValue());
        }

        //Traversal on HashMap using keySet()
        for(String key:hm.keySet()){
            System.out.println("Key: "+key+" -> Value: "+hm.get(key));
        }

        //Manipulation of HashMap
        //Adding an element into the HashMap
        hm.put("Exit", 4);
        System.out.println(hm);

        //Updating a key in the HashMap
        hm.put("Hello", 5);
        System.out.println(hm);

        //Deleting an element from the HashMap
        hm.remove("Exit");
        System.out.println(hm);
    }
}
