package MinimumSpanningTree_Kruskal;

import java.util.*;
import java.util.stream.Collectors;

class KruskalAlgorithm {

    private static int[] parents;

    static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {

        List<Edge> result = new ArrayList<>();

        Set<Integer> nodes = new HashSet<>();

        for (Edge edge : edges) {
            nodes.add(edge.getStartNode());
            nodes.add(edge.getEndNode());
        }

        parents = new int[nodes.size() + 1];

        for (Integer node : nodes) {
            parents[node] = node;
        }

        edges = edges.stream()
                .sorted(Comparator.comparingInt(Edge::getWeight))
                .collect(Collectors.toList());

        for (Edge edge : edges) {
            int startNode = edge.getStartNode();
            int endNode = edge.getEndNode();

            int firstRoot = findRoot(startNode);
            int secondRoot = findRoot(endNode);

            if (firstRoot != secondRoot){
                result.add(edge);
                parents[firstRoot] = secondRoot;
            }
        }

        return result;
    }

    private static int findRoot(int node) {
        while (parents[node] != node){
            node = parents[node];
        }
        return node;
    }
}
