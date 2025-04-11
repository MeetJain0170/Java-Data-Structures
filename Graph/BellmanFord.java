import java.util.Arrays;
public class BellmanFord {
    static int[] bellmanFord(int V, int[][]edges, int src){
        int[]dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0; i<V; i++){
            for(int[]edge:edges){
                int source = edge[0];
                int dest = edge[1];
                int wt = edge[2];
                
                if (dist[source]!=Integer.MAX_VALUE && dist[source]+wt<dist[dest]){
                    if(i==V-1){
                        return new int[]{-1};
                    }
                dist[dest] = dist[source]+wt;
                }
            }
        }return dist;
    }
    public static void main(String[] args) {
		int V = 5;
		int[][] edges = new int[][] { 
			{ 1, 3, 2 }, 
			{ 4, 3, -1}, 
			{ 2, 4, 1 }, 
			{ 1, 2, 1 }, 
			{ 0, 1, 5 } 
        };
		int src = 0;
		int[] ans = bellmanFord(V, edges, src);     
		for (int dist : ans)
			System.out.print(dist+" ");
	}
}
