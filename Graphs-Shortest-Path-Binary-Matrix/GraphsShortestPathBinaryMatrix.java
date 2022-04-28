class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) {
            return -1;
        }
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int level = 1;
        
        // [0, 1, 1]
        // [0, 0, 1]
        // [1, 0, 0]
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            while(!queue.isEmpty() && size > 0) {
                
                int[] position = queue.poll();

                int row = position[0];
                int col = position[1];

                if(row == (n - 1) && col == (n - 1)) {
                    return level;
                }

                for(int i = -1; i <= 1; i++) {
                    for(int j = -1; j <= 1; j++) {

                        int newRow = row + i;    
                        int newCol = col + j;

                        if(!(newRow == row && newCol == col) && 
                                (newRow >= 0 && newRow < n) &&
                                (newCol >= 0 && newCol < n) &&
                                grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = 1;
                            queue.offer(new int[]{newRow, newCol});
                        }

                    }
                }
                
                size--;
            }
            
            level++;
        }
        
        return -1;
    }
}