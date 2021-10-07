class Solution {
    
    int[] memoisation = new int[31];
    
    public int fib(int n) {
        
        if(n < 2) {
            return n;
        }
        
        memoisation[0] = 0;
        memoisation[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            memoisation[i] = memoisation[i - 1] + memoisation[i - 2];
        }
        
        return memoisation[n];
    }
}