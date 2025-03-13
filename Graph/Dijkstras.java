import java.util.*;

public class Dijkstras {
    static class Pair implements Comparable<Pair>{
        int dest,weight;
        Pair(int dest, int weight){
            this.dest=dest;
            this.weight=weight;
        }
    
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.weight, other.weight);
        }
    }

    private int V;
    private List<List<Pair>> adj;
    Dijkstras(int V){
        this.V=V;
        adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w){
        adj.get(u).add(new Pair(v,w));
        adj.get(v).add(new Pair(u,w));
    }

    void shortestPath(int src){
        PriorityQueue <Pair> pq =new PriorityQueue<>(V);
        int[]dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Pair(src,0));
        dist[src]=0;

        while(!pq.isEmpty()){
            int u = pq.poll().dest;
            for(Pair v:adj.get(u)){
                if(dist[v.dest] > dist[u] + v.weight){
                    dist[v.dest] = dist[u]+v.weight;
                    pq.add(new Pair(v.dest, dist[v.dest]));
                }
            }
        }
        System.err.println("Vertex distance from source");
        for(int i=0; i<V; i++){
            System.out.println(i+ "\t\t" +dist[i]);
        }
    }
    public static void main(String[] args) {
        Dijkstras graph = new Dijkstras(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);
        graph.addEdge(2, 3, 4);

        graph.shortestPath(0); 
    }
}
