class Solution {
    public int missingNumber(int[] nums) {
        
        // 1 2 3 = S
        // 3 2 1 = S
        
        double n = Double.valueOf(nums.length);
        double expectedSum = (n / 2) * (n + 1);
        double actualSum = 0;
        for(int i = 0; i < nums.length; i++) {
            actualSum += Double.valueOf(nums[i]);
        }
        return new Double(expectedSum - actualSum).intValue();
    }
}