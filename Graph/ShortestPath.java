public class ShortestPath {
    static final int V=9;
    int minDistance(int []dist, boolean[]sptSet){
        int min= Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=0;i<V;i++){
            if(sptSet[i]==false && dist[i]<min){
                min=dist[i];
                minIndex=i;
            }
        }return minIndex;
    }
    void dijkstra(int graph[][], int src){
        int dist[]= new int[V];
        boolean sptSet[]=new boolean[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        for(int count=0; count<V; count++){
            int u = minDistance(dist, sptSet);
            sptSet[u]=true;
            System.out.println(u+" ");
            for(int v=0; v<V;v++){
                if(!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }printSolution(dist);
    }
    void printSolution(int []dist){
        System.out.println();
        for(int i=0; i<V; i++){
            System.out.println(i+"\t\t"+dist[i]);
        }
    }
}
