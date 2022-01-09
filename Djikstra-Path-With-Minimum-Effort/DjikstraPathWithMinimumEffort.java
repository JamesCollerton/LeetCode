class Solution {
    
    private int numRows;
    private int numCols;
    private Node[][] graph;
    private boolean[][] visited;
    
    class Node {
        int distance = Integer.MAX_VALUE;
        final int height;
        final int row;
        final int col;
        Map<Node, Integer> adjacencyList = new HashMap<>();
        
        Node(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
        
        public void initialiseAdjacencyList() {
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int currRow = row + i;
                    int currCol = col + j;
                    if(!(currRow == row && currCol == col)) {
                        if(currRow >= 0 && currCol >= 0 && currRow < numRows && currCol < numCols) {
                            Node node = graph[currRow][currCol];
                            adjacencyList.put(node, node.height);
                        }
                    }   
                }
            }
        }
        
    }
    
    public int minimumEffortPath(int[][] heights) {
        
        this.numRows = heights.length;
        this.numCols = heights[0].length;
        
        graph = new Node[numRows][numCols];
        visited = new boolean[numRows][numCols];
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                graph[i][j] = new Node(heights[i][j], i, j);
            }
        }
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                graph[i][j].initialiseAdjacencyList();
            }
        }
        
        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        Node start = graph[0][0];
        start.distance = 0;
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            
            Node currentNode = queue.poll();
            seen.add(currentNode);
            
            for(Map.Entry<Node, Integer> entry: currentNode.adjacencyList.entrySet()) {
                Node node = entry.getKey();
                int distance = entry.getValue();
                                
                int newDistance = Math.max(currentNode.distance, Math.abs(currentNode.height - node.height));
                if(newDistance < node.distance) {
                    node.distance = newDistance;
                }
                
                if(!seen.contains(node)) {
                    queue.offer(node);
                }
            }
        }
        
        return graph[numRows - 1][numCols - 1].distance;
    }
}