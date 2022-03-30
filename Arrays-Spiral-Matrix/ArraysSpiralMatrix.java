class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rowS = 0;
        int colS = 0;
        int rowE = matrix.length - 1;
        int colE = matrix[0].length - 1;
        
        List<Integer> result = new LinkedList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        while(rowS <= rowE && colS <= colE) {
            
            for(int i = colS; i <= colE; i++) {
                result.add(matrix[rowS][i]);
            }
            rowS++;
            
            for(int i = rowS; i <= rowE; i++) {
                result.add(matrix[i][colE]);
            }
            colE--;
            
            if (rowS <= rowE) {
                for(int i = colE; i >= colS; i--) {
                    result.add(matrix[rowE][i]);
                }
            }
            rowE--;
            
            if(colS <= colE) {
                for(int i = rowE; i >= rowS; i--) {
                    result.add(matrix[i][colS]);
                }
            }
            colS++;
            
        }
        
        return result;
    }
}