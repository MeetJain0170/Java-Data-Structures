import java.util.*;

public class PrimsAlgo {
    static class Vertex implements Comparable<Vertex> {
        int node, weight;
        Vertex(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Vertex other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    private int V;
    private List<List<Vertex>> adjList;

    PrimsAlgo(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Vertex(dest, weight));
        adjList.get(dest).add(new Vertex(src, weight));
    }

    public void primsMST(int start) {
        int[] dist = new int[V]; // Stores the minimum weight to reach each node
        int[] parent = new int[V]; // Stores MST structure
        boolean[] inMST = new boolean[V]; // Tracks nodes included in MST
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        pq.add(new Vertex(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            inMST[u] = true; // Include this vertex in MST

            for (Vertex neighbor : adjList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                // If v is not in MST and we found a lower weight
                if (!inMST[v] && weight < dist[v]) {
                    dist[v] = weight;
                    parent[v] = u;  // Track MST edges
                    pq.add(new Vertex(v, weight));
                }
            }
        }

        // Print MST edges and total weight
        System.out.println("Edges in MST:");
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + " (Weight: " + dist[i] + ")");
                totalWeight += dist[i];
            }
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        PrimsAlgo g = new PrimsAlgo(9);
        g.addEdge(0, 1, 6);
        g.addEdge(0, 8, 4);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 6, 2);
        g.addEdge(2, 3, 1);
        g.addEdge(1, 3, 4);
        g.addEdge(5, 6, 3);
        g.addEdge(5, 8, 3);
        g.addEdge(6, 7, 6);
        g.addEdge(7, 5, 3);
        g.addEdge(3, 4, 6);
        g.addEdge(0, 3, 8);

        g.primsMST(0);
    }
}
