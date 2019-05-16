package GraphConnectivity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer>[] graph;

    private static boolean[] visited;

    private static void dfs(int n){
        if (!visited[n]){
            visited[n] = true;
            for (int child : graph[n]) {
                dfs(child);
            }
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {

        graph = new ArrayList[9];
        graph[0] =  new ArrayList<>() {{add(3); add(6);}};
        graph[1] =  new ArrayList<>() {{add(2); add(3); add(4); add(5); add(6);}};
        graph[2] =  new ArrayList<>() {{add(1); add(4); add(5);}};
        graph[3] =  new ArrayList<>() {{add(0); add(1); add(5);}};
        graph[4] =  new ArrayList<>() {{add(1); add(2); add(6);}};
        graph[5] = new ArrayList<>() {{add(1); add(2); add(3);}};
        graph[6] = new ArrayList<>() {{add(0); add(1); add(4);}};
        graph[7] = new ArrayList<>() {{add(8);}};
        graph[8] = new ArrayList<>() {{add(7);}};

        visited = new boolean[graph.length];

        int components = 0;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]){
                components++;
                System.out.print(String.format("Connected component %s: ", components));
                dfs(i);
                System.out.println();
            }
        }
    }
}
