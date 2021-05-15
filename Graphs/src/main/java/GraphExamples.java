import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    }

//    private static boolean bfs(List<List<Integer>> adjacencyList, int target, Set<Integer> seen) {
//
//    }

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
