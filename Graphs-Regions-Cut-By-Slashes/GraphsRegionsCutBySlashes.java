class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int[][] enlargedMatrix = new int[3 * grid.length][3 * grid.length];
        
        for(int row = 0; row < grid.length; row++) {
            String rowString = grid[row];
            
            for(int col = 0; col < rowString.length(); col++) {
                
                int enlargedGridRow = 3 * row;
                int enlargedGridCol = 3 * col;
                
                if(rowString.charAt(col) == '/') {
                    enlargedMatrix[enlargedGridRow + 2][enlargedGridCol] = 1;
                    enlargedMatrix[enlargedGridRow + 1][enlargedGridCol + 1] = 1;
                    enlargedMatrix[enlargedGridRow][enlargedGridCol + 2] = 1;
                } else if(rowString.charAt(col) == '\\') {
                    enlargedMatrix[enlargedGridRow][enlargedGridCol] = 1;
                    enlargedMatrix[enlargedGridRow + 1][enlargedGridCol + 1] = 1;
                    enlargedMatrix[enlargedGridRow + 2][enlargedGridCol + 2] = 1;     
                }
                
            }
        }
        
        int result = 0;
        
        for(int i = 0; i < enlargedMatrix.length; i++) {
            for(int j = 0; j < enlargedMatrix[i].length; j++) {
                if(enlargedMatrix[i][j] == 0) {
                    markMatrix(enlargedMatrix, i, j);
                    result++;
                }
            }
        }
                                                 
        return result;
    }
    
    private int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void markMatrix(int[][] matrix, int row, int col) {
        if(
            row < 0 || col < 0 || 
            row >= matrix.length || 
            col >= matrix[row].length || 
            matrix[row][col] != 0) {
            return;
        }
        matrix[row][col] = 2;
        for(int[] move: moves) {
            markMatrix(matrix, row + move[0], col + move[1]);
        }
    }
}