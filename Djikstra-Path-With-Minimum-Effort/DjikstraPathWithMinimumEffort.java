class Solution {
    
    private final int ROW = 0;
    private final int COL = 1;
    private int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minimumEffortPath(int[][] heights) {
        
        int numRows = heights.length;
        int numCols = heights[0].length;
        
        boolean[][] visited = new boolean[numRows][numCols];
        int[][] distance = new int[numRows][numCols];
                
        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<int[]> queue = new PriorityQueue<>(
            (a, b) -> distance[a[ROW]][a[COL]] - distance[b[ROW]][b[COL]]
        );
        int[] start = new int[]{0, 0};
        distance[start[ROW]][start[COL]] = 0;
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            
            int[] currentCoordinates = queue.poll();
            int currRow = currentCoordinates[ROW];
            int currCol = currentCoordinates[COL];
            visited[currRow][currCol] = true;
                        
            for(int[] move: moves) {
                
                int i = move[0];
                int j = move[1];
                int nextRow = currRow + i;
                int nextCol = currCol + j;
                
                if(nextRow >= 0 && nextCol >= 0 && nextRow < numRows && nextCol < numCols) {

                    int newEffort = Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol]);
                    int newDistance = Math.max(distance[currRow][currCol], newEffort);

                    if(newDistance < distance[nextRow][nextCol]) {
                        distance[nextRow][nextCol] = newDistance;
                        queue.offer(new int[]{nextRow, nextCol});
                    }

                }
            }
            
        }
        
        return distance[numRows - 1][numCols - 1];
    }
}