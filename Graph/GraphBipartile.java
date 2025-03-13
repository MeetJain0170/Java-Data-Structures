import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartile {
    public static boolean isBipartite(int[][] gr) {
        int n = gr.length;
        int[] colour = new int[n];

        for (int node = 0; node < n; node++) {
            if (colour[node] != 0) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            colour[node] = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int ne : gr[cur]) {
                    if (colour[ne] == 0) {
                        colour[ne] = -colour[cur];
                        q.add(ne);
                    } else if (colour[ne] != -colour[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
