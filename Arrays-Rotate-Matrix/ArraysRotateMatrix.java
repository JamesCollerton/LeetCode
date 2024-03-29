class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // Reverse order of rows
        for(int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i]; 
            matrix[n - 1 - i] = temp; 
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
}