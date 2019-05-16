package MinimumSpanningTree_Prim;

import java.util.*;

class PrimAlgorithm {

    static List<Edge> prim(int numberOfVertices, List<Edge> graphEdges) {

        List<Integer> spanningTree = new ArrayList<>();

        TreeSet<Integer> nodes = new TreeSet<>();

        for (Edge edge : graphEdges) {
            nodes.add(edge.getStartNode());
            nodes.add(edge.getEndNode());
        }

        Integer startingNode = nodes.first();

        Map<Integer, List<Edge>> nodeToEdges = new HashMap<>();

        for (Edge graphEdge : graphEdges) {
            if (!nodeToEdges.containsKey(graphEdge.getStartNode())){
                nodeToEdges.put(graphEdge.getStartNode(), new ArrayList<>());
            }

            if (!nodeToEdges.containsKey(graphEdge.getEndNode())){
                nodeToEdges.put(graphEdge.getEndNode(), new ArrayList<>());
            }

            nodeToEdges.get(graphEdge.getStartNode()).add(graphEdge);
            nodeToEdges.get(graphEdge.getEndNode()).add(graphEdge);
        }

        List<Edge> result = new ArrayList<>();

        for (Integer node : nodes) {
            if (!spanningTree.contains(node)){
                spanningTree.add(startingNode);

                List<Edge> startingEdges = nodeToEdges.get(startingNode);

                PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(startingEdges);

                while (priorityQueue.size() != 0){
                    Edge minEdge = priorityQueue.peek();
                    priorityQueue.remove(minEdge);

                    int startNode = minEdge.getStartNode();
                    int endNode = minEdge.getEndNode();

                    int nonTreeNode = -1;

                    if (spanningTree.contains(startNode) && !spanningTree.contains(endNode)){
                        nonTreeNode = endNode;
                    }
                    if (spanningTree.contains(endNode) && !spanningTree.contains(startNode)){
                        nonTreeNode = startNode;
                    }

                    if (nonTreeNode == -1){
                        continue;
                    }

                    spanningTree.add(nonTreeNode);

                    priorityQueue.addAll(nodeToEdges.get(nonTreeNode));

                    result.add(minEdge);
                }
            }
        }
        return result;
    }
}
