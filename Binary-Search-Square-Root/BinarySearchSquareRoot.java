class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left <= right) {
            long mid = left + ((right - left) / 2);
            
            // System.out.println("Mid " + mid);
            // System.out.println("Left " + left);
            // System.out.println("Right " + right);
            
            if(mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                if((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
}