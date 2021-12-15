class Solution {
    public int maxWidthRamp(int[] nums) {

        int[] maxFromRight = new int[nums.length];
        
        maxFromRight[nums.length - 1] = nums[nums.length - 1];
        
        for(int i = nums.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], nums[i]);
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        
        while(right < nums.length) {
            
            if(left < right && nums[left] > maxFromRight[right]) {
                left++;
            } else {
                ans = Math.max(ans, right - left);
                right++;
            }
            
        }
        
        return ans;
    }
}