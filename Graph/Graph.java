import java.util.*;

public class Graph {
    private final int[][] residual;
    private final int size;
    private final String[] vertexData;

    public Graph(int size) {
        this.size = size;
        this.residual = new int[size][size];
        this.vertexData = new String[size];
        Arrays.fill(this.vertexData, "");
    }

    public void addEdge(int u, int v, int c) {
        if (u < 0 || v < 0 || u >= size || v >= size) {
            throw new IllegalArgumentException("Vertex index out of bounds");
        }
        if (c < 0) throw new IllegalArgumentException("Capacity must be non-negative");
        residual[u][v] = c;
    }

    public void addVertexData(int vertex, String data) {
        if (0 <= vertex && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    // ---------- DFS (for Ford–Fulkerson) ----------
    private List<Integer> dfsPath(int s, int t) {
        boolean[] visited = new boolean[size];
        List<Integer> path = new ArrayList<>();
        return dfsUtil(s, t, visited, path) ? path : null;
    }

    private boolean dfsUtil(int u, int t, boolean[] visited, List<Integer> path) {
        visited[u] = true;
        path.add(u);
        if (u == t) return true;
        for (int v = 0; v < size; v++) {
            if (residual[u][v] > 0 && !visited[v]) {
                if (dfsUtil(v, t, visited, path)) return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public int fordFulkerson(int source, int sink) {
        int maxFlow = 0;
        List<Integer> path;
        while ((path = dfsPath(source, sink)) != null) {
            int pathFlow = Integer.MAX_VALUE;

            // bottleneck along this augmenting path
            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            // update residual graph
            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;

            // pretty-print path using names (fallback to indices if empty)
            List<String> pathNames = new ArrayList<>();
            for (int node : path) {
                pathNames.add(vertexData[node].isEmpty() ? String.valueOf(node) : vertexData[node]);
            }
            System.out.println("Path: " + String.join(" -> ", pathNames) + " with flow " + pathFlow);
        }
        return maxFlow;
    }

    // ---------- BFS (for Edmonds–Karp) ----------
    private List<Integer> bfsPath(int s, int t) {
        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == t) {
                List<Integer> path = new ArrayList<>();
                for (int v = t; v != -1; v = parent[v]) path.add(v);
                Collections.reverse(path);
                return path;
            }
            for (int v = 0; v < size; v++) {
                if (residual[u][v] > 0 && !visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
        return null;
    }

    public int fordFulkersonEK(int source, int sink) {
        int maxFlow = 0;
        List<Integer> path;
        while ((path = bfsPath(source, sink)) != null) {
            int bottleneck = Integer.MAX_VALUE;

            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                bottleneck = Math.min(bottleneck, residual[u][v]);
            }

            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                residual[u][v] -= bottleneck;
                residual[v][u] += bottleneck;
            }

            maxFlow += bottleneck;

            List<String> pathNames = new ArrayList<>();
            for (int node : path) {
                pathNames.add(vertexData[node].isEmpty() ? String.valueOf(node) : vertexData[node]);
            }
            System.out.println("Path: " + String.join(" -> ", pathNames) + " with flow " + bottleneck);
        }
        return maxFlow;
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        Graph g = new Graph(6);
        String[] names = {"s", "v1", "v2", "v3", "v4", "t"};
        for (int i = 0; i < names.length; i++) g.addVertexData(i, names[i]);

        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 7);
        g.addEdge(1, 3, 3);
        g.addEdge(1, 4, 4);
        g.addEdge(2, 1, 5);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 6);

        int max = g.fordFulkerson(0, 5);
        System.out.println("The maximum possible flow (DFS/FF) is " + max);

        // fresh graph for Edmonds–Karp
        g = new Graph(6);
        for (int i = 0; i < names.length; i++) g.addVertexData(i, names[i]);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 7);
        g.addEdge(1, 3, 3);
        g.addEdge(1, 4, 4);
        g.addEdge(2, 1, 5);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 6);

        int maxEK = g.fordFulkersonEK(0, 5);
        System.out.println("The maximum possible flow (BFS/EK) is " + maxEK);
    }
}