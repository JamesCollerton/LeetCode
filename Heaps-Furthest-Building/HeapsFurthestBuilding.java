class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        
        for(int i = 0; i < heights.length; i++) {
            if(i == heights.length - 1) {
                return i;
            }
            
            if(heights[i] < heights[i + 1]) {
                if(ladders > 0) {
                    ladders--;
                    queue.offer(heights[i + 1] - heights[i]);
                } else {
                    queue.offer(heights[i + 1] - heights[i]);
                    int difference = queue.poll();
                    
                    if(difference > bricks) {
                        return i;
                    } else {
                        bricks = bricks - difference;
                    }
                }
            }
        }
        
        return heights.length - 1;
    }
}