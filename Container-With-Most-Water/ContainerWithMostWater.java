class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = (height.length - 1);
        int maxArea = 0;
        
        while(p1 < p2) {
            int area = calculateArea(height, p1, p2);
            if(area > maxArea) {
                maxArea = area;
            }
            
            if(height[p1] < height[p2]) {
                p1 = findNewP1(p1, height);
            } else if (height[p1] > height[p2]) {
                p2 = findNewP2(p2, height);
            } else {
                p1 = findNewP1(p1, height);
                p2 = findNewP2(p2, height);
            }
        }
        
        return maxArea;
    }
    
    private int findNewP1(int p1, int[] height) {
        int currentHeight = height[p1];
        while(p1 < height.length && height[p1] <= currentHeight) {
            p1++;
        }
        return p1;
    }
        
    private int findNewP2(int p2, int[] height) {
        int currentHeight = height[p2];
        while(p2 > 0 && height[p2] <= currentHeight) {
            p2--;
        }
        return p2;
    }
    
    private int calculateArea(int[] height, int p1, int p2) {
        return height[p1] < height[p2] ? height[p1] * (p2 - p1) : height[p2] * (p2 - p1);
    }
}