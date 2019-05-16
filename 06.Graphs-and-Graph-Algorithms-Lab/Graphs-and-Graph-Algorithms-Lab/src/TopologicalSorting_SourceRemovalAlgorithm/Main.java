package TopologicalSorting_SourceRemovalAlgorithm;

import java.util.*;

public class Main {
    private static List<Integer>[] graph;

    private static boolean[] visited;

    public static void main(String[] args) {

        graph = new ArrayList[6];
        graph[0] = new ArrayList<>() {{
            add(1);
            add(2);
        }};
        graph[1] = new ArrayList<>() {{
            add(3);
            add(4);
        }};
        graph[2] = new ArrayList<>() {{
            add(5);
        }};
        graph[3] = new ArrayList<>() {{
            add(2);
            add(5);
        }};
        graph[4] = new ArrayList<>() {{
            add(3);
        }};
        graph[5] = new ArrayList<>() {
        };

        List<Integer> result = new ArrayList<>();
        Set<Integer> nodes = new LinkedHashSet<>();

        HashSet<Integer> nodeWithIncomingEdges = getNodesWithIncomingEdges();

        for (int i = 0; i < graph.length; i++) {
            if (!nodeWithIncomingEdges.contains(i)){
                nodes.add(i);
            }
        }

        while (nodes.size() != 0){
            Integer currentNode = nodes.iterator().next();
            nodes.remove(currentNode);
            result.add(currentNode);

            List<Integer> children = graph[currentNode];
            graph[currentNode] = new ArrayList<>();

            HashSet<Integer> leftNodesWithIncomingEdges = getNodesWithIncomingEdges();

            for (Integer child : children) {
                if (!leftNodesWithIncomingEdges.contains(child)){
                    nodes.add(child);
                }
            }
        }

        List<Integer> edgesLeft = new ArrayList<>();
        for (List<Integer> node : graph) {
            edgesLeft.addAll(node);
        }

        if (!edgesLeft.isEmpty()){
            System.out.println("Sorry");
        } else {
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }

    private static HashSet<Integer> getNodesWithIncomingEdges() {
        HashSet<Integer> nodeWithIncomingEdges = new HashSet<>();

        for (List<Integer> node : graph) {
            nodeWithIncomingEdges.addAll(node);
        }
        return nodeWithIncomingEdges;
    }
}

