class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean firstRowsZeros = false;
        boolean firstColsZeros = false;
        
        // Find out if any of the first row are zeros, if so this
        // means we need to set the first row to zero.
        for(int col = 0; col < matrix[0].length; col++) {
            if(matrix[0][col] == 0) {
                firstRowsZeros = true;
            }
        }
              
        // Find out if any of the first column are zeros, if so this
        // means we need to set the first column to zero.
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == 0) {
                firstColsZeros = true;
            }
        }
        
        // Go through whole matrix. If any are zero note this in the
        // first row or column
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 1; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }    
            }
        }
        
        // Go through all the rows and check to see if the first number
        // is zero. If so modify the matrix.
        for(int row = matrix.length - 1; row > 0; row--) {
            if(matrix[row][0] == 0) {
                for(int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // Do the same for columns
        for(int col = matrix[0].length - 1; col > 0; col--) {
            if(matrix[0][col] == 0) {
                for(int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        if(firstRowsZeros) {
            for(int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        
        if(firstColsZeros) {
            for(int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
        
    }
}