import java.util.Arrays;

public class FractionalKnapsack {
    
    static class ItemValues {
        int weight;
        int profit;

        ItemValues(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    public static double getMaxValue(ItemValues[] items, int capacity) {
        // Sorting items based on profit/weight ratio in descending order
        Arrays.sort(items, (item1, item2) -> {
            double r1 = (double) item1.profit / item1.weight; // Ensure floating-point division
            double r2 = (double) item2.profit / item2.weight;
            return Double.compare(r2, r1); // Descending order
        });

        double totalValue = 0.0;

        for (ItemValues item : items) {
            if (capacity >= item.weight) { // If the item can be fully taken
                capacity -= item.weight;
                totalValue += item.profit;
            } else { // Take fraction of the item
                totalValue += item.profit * ((double) capacity / item.weight);
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        ItemValues[] items = {
            new ItemValues(10, 60),
            new ItemValues(20, 100),
            new ItemValues(30, 120)
        };
        
        int capacity = 50;
        
        System.out.println("Maximum value in Knapsack = " + getMaxValue(items, capacity));
    }
}
