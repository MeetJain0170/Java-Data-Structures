import java.util.*;

public class KnapSack01 {
    static final int[] weights = {10, 20, 30};
    static final int[] profits = {60, 100, 120};
    static final int W = 50;
    static final int n = weights.length;

    static class KnapsackNode {
        int level;
        int profit;
        int weight;
        double bound;
        List<Integer> items = new ArrayList<>();

        KnapsackNode(int level, int profit, int weight) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
        }

        KnapsackNode() {
            this(-1, 0, 0);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<KnapsackNode> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> -n.bound));
        KnapsackNode root = new KnapsackNode();
        root.bound = calculateBound(root);
        pq.add(root);

        int maxProfit = 0;
        List<Integer> bestItems = new ArrayList<>();

        while (!pq.isEmpty()) {
            KnapsackNode current = pq.poll();
            if (current.bound <= maxProfit || current.level == n - 1) continue;

            int nextLevel = current.level + 1;

            KnapsackNode include = new KnapsackNode(nextLevel,
                    current.profit + profits[nextLevel],
                    current.weight + weights[nextLevel]);
            include.items = new ArrayList<>(current.items);
            include.items.add(nextLevel);
            include.bound = calculateBound(include);

            if (include.weight <= W && include.profit > maxProfit) {
                maxProfit = include.profit;
                bestItems = include.items;
            }
            if (include.bound > maxProfit) pq.add(include);

            KnapsackNode exclude = new KnapsackNode(nextLevel, current.profit, current.weight);
            exclude.items = new ArrayList<>(current.items);
            exclude.bound = calculateBound(exclude);
            if (exclude.bound > maxProfit) pq.add(exclude);
        }

        System.out.println("Maximum Profit: " + maxProfit);
        System.out.println("Items included (0-based index): " + bestItems);
    }

    static double calculateBound(KnapsackNode node) {
        if (node.weight >= W) return 0;

        double profitBound = node.profit;
        int totalWeight = node.weight;
        int index = node.level + 1;

        while (index < n && totalWeight + weights[index] <= W) {
            totalWeight += weights[index];
            profitBound += profits[index];
            index++;
        }

        if (index < n) {
            profitBound += (W - totalWeight) * (double) profits[index] / weights[index];
        }

        return profitBound;
    }
}
