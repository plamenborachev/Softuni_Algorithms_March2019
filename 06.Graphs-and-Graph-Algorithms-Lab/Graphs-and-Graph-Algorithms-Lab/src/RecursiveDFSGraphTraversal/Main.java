package RecursiveDFSGraphTraversal;

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
            System.out.println(n);
        }
    }

    public static void main(String[] args) {

        graph = new ArrayList[7];
        graph[0] =  new ArrayList<>() {{add(3); add(6);}};
        graph[1] =  new ArrayList<>() {{add(2); add(3); add(4); add(5); add(6);}};
        graph[2] =  new ArrayList<>() {{add(1); add(4); add(5);}};
        graph[3] =  new ArrayList<>() {{add(0); add(1); add(5);}};
        graph[4] =  new ArrayList<>() {{add(1); add(2); add(6);}};
        graph[5] = new ArrayList<>() {{add(1); add(2); add(3);}};
        graph[6] = new ArrayList<>() {{add(0); add(1); add(4);}};

        visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfs(i);
        }
    }
}
