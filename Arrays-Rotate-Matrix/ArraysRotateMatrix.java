class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        
        while(rowS < rowE) {
            
            int incr = 0;
            int temp = 0;
            int prevValue = 0;
            
            while(rowS + incr < rowE) {
                
                prevValue = matrix[rowS + incr][colE];
                matrix[rowS + incr][colE] = matrix[rowS][colS + incr];
                
                temp = matrix[rowE][colE - incr];
                matrix[rowE][colE - incr] = prevValue;
                prevValue = temp;
                
                temp = matrix[rowE - incr][colS];
                matrix[rowE - incr][colS] = prevValue;
                prevValue = temp;
                
                matrix[rowS][colS + incr] = prevValue;
                
                incr++;
            }
            
            rowS++;
            rowE--;
            colS++;
            colE--;
            
        }
        
    }
    
}