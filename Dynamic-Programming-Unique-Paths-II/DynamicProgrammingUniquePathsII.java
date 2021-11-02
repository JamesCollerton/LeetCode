class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
           return 0; 
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] memoisation = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    memoisation[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    memoisation[i][j] = 0;
                } else {
                    int value;
                    if(i - 1 < 0) {
                        value = memoisation[i][j - 1];
                    } else if(j - 1 < 0) {
                        value = memoisation[i - 1][j];
                    } else {
                        value = memoisation[i - 1][j] + memoisation[i][j - 1];
                    }
                    memoisation[i][j] = value; 
                }
            }
        }
                
        return memoisation[m - 1][n - 1];
    }
}