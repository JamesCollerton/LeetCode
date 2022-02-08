class Solution {
        
    private int[][] memoisation = new int[20][20];
    
    public int numTrees(int n) {
        
        for(int i = 0; i < memoisation.length; i++) {
            for(int j = 0; j < memoisation.length; j++) {
                memoisation[i][j] = -1;    
            }
        }
        
        return trees(1, n);
    }

    private int trees(int lo, int hi) {
        if (lo >= hi) {
            return 1;
        }
        
        if(memoisation[lo][hi] != -1) {
            return memoisation[lo][hi];
        }
        
        int total = 0;
        for (int i = lo; i <= hi; i++) {
            total += trees(lo, i - 1) * trees(i + 1, hi);
        }
        memoisation[lo][hi] = total;
        return total;
    }
    
}