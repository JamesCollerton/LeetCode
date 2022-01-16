class Solution {
    
    private int max = 0;
    private int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int ROW = 0;
    private final int COL = 1;
    private int numRows;
    private int numCols;
        
    public int longestIncreasingPath(int[][] matrix) {
                
        numRows = matrix.length;
        numCols = matrix[0].length;
                
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                System.out.println();
                dfs(i, j, initialiseSeen(), 0);
            }
        }
        
        return max;
    }
    
    private void dfs(int row, int col, boolean[][] seen, int currentMax) {
        
        seen[row][col] = true;
        
        max = Math.max(currentMax + 1, max);
        
        // System.out.println(row + "," + col);
        
        for(int[] move: moves) {
            int newRow = row + move[ROW];
            int newCol = col + move[COL];
            System.out.println(move[ROW]);
            System.out.println(move[COL]);
            
            if(newRow >= 0 && newCol >= 0 && newRow < numRows && newCol < numCols) {
                System.out.println(row + "," + col + ": " + newRow + "," + newCol + " " + seen[newRow][newCol]);
                if(!seen[newRow][newCol]) {
                    dfs(newRow, newCol, cloneArray(seen), currentMax + 1);
                }
            }
        }
                        
    }
    
    private boolean[][] initialiseSeen() {
        boolean[][] newArr = new boolean[numRows][numCols];
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr[0].length; j++) {
                newArr[i][j] = false;
            }
        }
        return newArr;
    }
    
    private boolean[][] cloneArray(boolean[][] arr) {
        boolean[][] newArr = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }
}