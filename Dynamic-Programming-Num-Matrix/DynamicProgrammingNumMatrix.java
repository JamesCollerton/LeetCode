class NumMatrix {

    private int[][] dp;
    private int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        
        // Do everything starting from 1 to stop
        // us having to check if what is before
        // exists
        this.dp = new int[matrix.length + 1][matrix[0].length + 1];
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];    
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */