class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        
        int start = points[0][0];
        int end = points[0][1];
        
        int arrows = 0;
        
        for(int[] point: points) {
            int pointStart = point[0];
            int pointEnd = point[1];
            if(end >= pointStart && start <= pointEnd) {
                start = Math.min(start, pointStart);
                end = Math.min(end, pointEnd);
            } else {
                start = pointStart;
                end = pointEnd;
                arrows++;
            }
        }
        
        arrows++;
        
        return arrows;
    }
}