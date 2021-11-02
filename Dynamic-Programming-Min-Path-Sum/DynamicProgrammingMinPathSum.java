class Solution {
    
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] memoisation = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    memoisation[i][j] = grid[i][j];
                } else {
                    int value;
                    if(i - 1 < 0) {
                        value = memoisation[i][j - 1];
                    } else if(j - 1 < 0) {
                        value = memoisation[i - 1][j];
                    } else {
                        value = memoisation[i][j - 1] < memoisation[i - 1][j] ? memoisation[i][j - 1] : memoisation[i - 1][j];
                    }
                    memoisation[i][j] = grid[i][j] + value; 
                }
            }
        }
        
        
        return memoisation[m - 1][n - 1];
    }
}