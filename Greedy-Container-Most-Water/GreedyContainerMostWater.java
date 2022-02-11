class Solution {
    public int maxArea(int[] height) {
        
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        
        while(start < end) {
            int newArea = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max, newArea);
            if(height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        
        return max;
    }
}