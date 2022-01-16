class Solution {
    
    private int max = 1;
    private int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int ROW = 0;
    private final int COL = 1;
    private int numRows;
    private int numCols;
    private int[][] matrix;
        
    public int longestIncreasingPath(int[][] matrix) {
                
        if(matrix.length == 0) {
            return 0;
        }
        
        numRows = matrix.length;
        numCols = matrix[0].length;
        this.matrix = matrix;
        int[][] memoisation = new int[numRows][numCols];
                
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                max = Math.max(max, dfs(i, j, memoisation));
            }
        }
        
        return max;
    }
    
    private int dfs(int row, int col, int[][] memoisation) {
                
        if(memoisation[row][col] != 0) {
            return memoisation[row][col];
        }
        
        int max = 1;
        
        for(int[] move: moves) {
            int newRow = row + move[ROW];
            int newCol = col + move[COL];
            
            if(newRow >= 0 && newCol >= 0 && newRow < numRows && newCol < numCols) {
                if(matrix[newRow][newCol] > matrix[row][col]) {
                    int newMax = 1 + dfs(newRow, newCol, memoisation);
                    max = Math.max(newMax, max);
                }
            }
        }
        
        memoisation[row][col] = max;
        
        return max;                
    }
    
}