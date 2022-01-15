class Solution {
    public void sortColors(int[] nums) {
        int[] colourToCount = new int[3];
        for(int i = 0; i < nums.length; i++) {
            colourToCount[nums[i]]++;
        }
        int k = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < colourToCount[i]; j++) {
                nums[k] = i;
                k++;
            }
        }
    }
}