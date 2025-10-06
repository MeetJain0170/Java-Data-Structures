import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s){
        HashMap<Character, Integer> freqMap= new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a,b)->freqMap.get(b)-freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        StringBuilder res = new StringBuilder();
        while(maxHeap.size() > 1){
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            res.append(first).append(second);
            freqMap.put(first, freqMap.get(first) - 1);
            freqMap.put(second, freqMap.get(second) - 1);

            if(freqMap.get(first) > 0){
                maxHeap.add(first);
            }
            if(freqMap.get(second) > 0){
                maxHeap.add(second);
            }
        }
        if (!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            if(freqMap.get(ch) > 1){
                return ""; // Not possible to reorganize
            }
            res.append(ch);
        }return res.toString();
    }
    public static void main(String[] args) {
        String s = "aaabc";
        String result = reorganizeString(s);
        System.out.println(result); // Example output: "ababac" or similar
    }
}
