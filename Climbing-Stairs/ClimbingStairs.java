class Solution {
    public int climbStairs(int n) {
        
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        
        int two_before = 1;
        int one_before = 2;
        int step = 0;
        
        for(int i = 2; i < n; i++) {
            step = two_before + one_before;
            two_before = one_before;
            one_before = step;
        }
        
        return step;
    }
}