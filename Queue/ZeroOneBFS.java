import java.util.*;

public class ZeroOneBFS {
    static class Vertice {
        int dest;
        int weight;

        Vertice(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static final int numVertex = 9;
    private ArrayList<Vertice>[] edges;

    @SuppressWarnings("unchecked")
    ZeroOneBFS() {
        edges = (ArrayList<Vertice>[]) new ArrayList[numVertex];
        for (int i = 0; i < numVertex; i++) {
            edges[i] = new ArrayList<>();
    }
}

    void addEdge(int u, int v, int w) {
        edges[u].add(new Vertice(v, w));  
        edges[v].add(new Vertice(u, w));
    }

    public void BFS(int src) {
        int dist[] = new int[numVertex];
        Arrays.fill(dist, Integer.MAX_VALUE); 

        Deque<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int v = q.removeFirst();

            for (int i = 0; i < edges[v].size(); i++) { 
                Vertice neighbor = edges[v].get(i);

                if (dist[neighbor.dest] > dist[v] + neighbor.weight) {
                    dist[neighbor.dest] = dist[v] + neighbor.weight;

                    if (neighbor.weight == 0) {
                        q.addFirst(neighbor.dest);
                    } else {
                        q.addLast(neighbor.dest);
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " "); 
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroOneBFS graph = new ZeroOneBFS();
        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 4, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(5, 6, 0);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 0);
        
        System.out.println("Shortest path distances from source 0:");
        graph.BFS(0);
    }
}
