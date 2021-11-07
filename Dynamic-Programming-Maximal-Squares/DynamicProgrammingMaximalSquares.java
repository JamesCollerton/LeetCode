class Solution {
    
    int[][] dp = new int[300][300];
    
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    if(i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result * result;
    }
}