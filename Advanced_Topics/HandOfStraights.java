import java.util.*;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int gs) {
        int totalCards = hand.length;
        if (totalCards % gs != 0){
            return false; // Cannot form groups of size gs
        }

        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for(int card : hand) {
            cardCount.merge(card,1,Integer::sum);
            }
        while(!cardCount.isEmpty()) {
            int start = cardCount.firstKey();
            for(int card = start; card < start + gs; card++) {
                Integer frequency = cardCount.get(card);
                if (frequency == null || frequency <= 0) {
                    return false; // Card not found or frequency is zero
                }

                if(frequency == 1) {
                    cardCount.remove(card); // Remove card if frequency is 1
                } else {
                    cardCount.put(card, frequency - 1); // Decrease frequency
                }
            }
        }return true; // Successfully formed a group
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 3, 4, 5};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize)); // Output: true
    }
}
