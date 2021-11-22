class Solution {
    public void setZeroes(int[][] matrix) {
        
        Set<Integer> rowsToConvert = new HashSet<>();
        Set<Integer> colsToConvert = new HashSet<>();
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    rowsToConvert.add(row);
                    colsToConvert.add(col);
                }    
            }
        }
        
        for(int row: rowsToConvert) {
            for(int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
        
        for(int col: colsToConvert) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        
    }
}