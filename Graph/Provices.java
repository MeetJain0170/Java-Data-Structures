public class Provices {
    public static int findCircleNum(int [][] isConnected){
        int size=isConnected.length;
        boolean[] visited=new boolean[size];
        int count=0;

        for(int node=0; node<size; node++){
            if(!visited[node]){
                count++;
                dfs(isConnected,node,visited);
            }       
        }return count;
    }

    public static void dfs(int[][] isConnected, int node, boolean[]visited){
        for(int neighbours=0; neighbours<isConnected[node].length; neighbours++){
            if(!visited[neighbours] && isConnected[node][neighbours]!=0){
               visited[neighbours]=true;
               dfs(isConnected, neighbours, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected={{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));;
    }
}
