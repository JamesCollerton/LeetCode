import java.util.*;

public class GraphExamples {

    public static void main(String[] args) {

        int maxNodeNumber = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
                {0, 3}
        };
        List<List<Integer>> adjacencyList = initialiseGraph(edges, maxNodeNumber);

        for(int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("Node " + i + " connected to nodes " + adjacencyList.get(i));
        }

        System.out.println("Node 3 can be found: " + dfs(adjacencyList, 3));
        System.out.println("Node 4 can be found: " + dfs(adjacencyList, 4));
    }

    private static boolean bfs(List<List<Integer>> adjacencyList, int target) {

        // Initialise a list of seen nodes. Note, this
        // is different to a tree as we may have cycles
        // within the graph. Also initialise the queue
        // we will be using to track which nodes to visit
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Initialise our queue
        int start = 1;
        queue.add(start);

        // While the queue is not empty take a node off the
        // queue, if it is what we are searching for we can
        // return true. Otherwise mark the node as seen and
        // and add all unseen nodes it connects to to the queue
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            if(currentNode == target) {
                return true;
            }

            seen.add(currentNode);

            for(int connectedNode: adjacencyList.get(currentNode)) {
                if(!seen.contains(connectedNode)) {
                    queue.add(connectedNode);
                }
            }
        }

        return false;
    }

    // Small wrapper method where we initialise a set of seen nodes
    // to pass to the recursive method.
    private static boolean dfs(List<List<Integer>> adjacencyList, int target) {
        HashSet<Integer> seen = new HashSet<>();
        int start = 1;
        return dfs(adjacencyList, start, target, seen);
    }

    // Recursively call this method in order to go down any of the paths
    // for a node
    private static boolean dfs(List<List<Integer>> adjacencyList, int currentNode, int target, HashSet<Integer> seen) {
        // If we found our target we can stop
        if(currentNode == target) {
            return true;
        }

        // We need to keep track of nodes we
        // have seen to prevent repeated visiting
        seen.add(currentNode);

        // For each node connected to this one, visit it
        // if any of them match our target we can stop and
        // return true. Otherwise return false as we have
        // not found it!
        for(int connectedNode: adjacencyList.get(currentNode)) {
            if(!seen.contains(connectedNode)) {
                if(dfs(adjacencyList, connectedNode, target, seen)){
                    return true;
                }
            }
        }

        return false;
    }

    private static List<List<Integer>> initialiseGraph(int[][] edges, int numberNodes) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i <= numberNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];
            adjacencyList.get(source).add(dest);
            adjacencyList.get(dest).add(source);
        }

        return adjacencyList;
    }

}
