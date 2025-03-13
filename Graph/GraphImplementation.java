import java.util.*;

public class GraphImplementation {
    private int vertices;
    private LinkedList<Integer>[] adjList;

//Constructor
    @SuppressWarnings("unchecked")
    public GraphImplementation(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        
        for(int i=0; i<vertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    //add edge to the graph
    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        
        //for undirected graph, uncomment the next line
        adjList[destination].add(source);
    }

    public void BFS(int startVertex){ //breadth first search
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for(int neighbor : adjList[vertex]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }   
            }
        }System.out.println();
    }

    public void DFS(int startVertex){ // Depth First Search using Recurssion
        boolean[] visited = new boolean[vertices]; 
        DFSUtil(startVertex, visited);
        System.out.println();
    }
    
    public void DFSUtil(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.print(vertex+" ");

        for(int neighbor : adjList[vertex]){
            if(!visited[neighbor]){
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFSIterative(int startVertex){// Depth First Search using Stacks        
        boolean[] visited = new boolean[vertices];  
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while(!stack.isEmpty()){
            int vertex = stack.pop();

            if(!visited[vertex]){
                visited[vertex]=true;
                System.out.print(vertex+" ");

                //Note: To maintain proper order similar to recursive DFS
                for(int neighbor:adjList[vertex]){
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }System.out.println();
    }
    
    public static void main(String[] args) {
        GraphImplementation graph = new GraphImplementation(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        
        System.out.println("Breadth First Traversal starting from index: ");
        graph.BFS(0);

        System.out.println("Depth First Traversal using Recursion starting from index: ");
        graph.DFS(0);

        System.out.println("Depth First Traversal using Stacks starting from index: ");
        graph.DFSIterative(0);
    }
}