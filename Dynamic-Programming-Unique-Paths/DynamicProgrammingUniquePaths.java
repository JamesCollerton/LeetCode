class Solution {
    
    private int[][] memoisation;
    private int m;
    private int n;
    
    public int uniquePaths(int m, int n) {
        
        memoisation = new int[m][n];
        this.m = m;
        this.n = n;
        
        memoisation[0][0] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    memoisation[i][j] = 1;
                } else {
                    int value;
                    if(i - 1 < 0) {
                        value = memoisation[i][j - 1];
                    } else if (j - 1 < 0) {
                        value = memoisation[i - 1][j];
                    } else {
                        value = memoisation[i][j - 1] + memoisation[i - 1][j];
                    }
                    memoisation[i][j] = value;
                }
            }
        }
        
        return memoisation[m - 1][n - 1];
    }
    
}