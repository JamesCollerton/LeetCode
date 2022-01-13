class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // These are all the places the height can change, we have
        // the position and the height it changes to
        List<List<Integer>> heights = new ArrayList<>();
        
        // We need to separate the points out into two:
        // - The start point, when a building height can go up
        // - The end point, when a building height can go down
        for(int[] b:buildings) {
            
            int left = b[0];
            int right = b[1];
            int height = b[2];
            
            // Start point has negative height value. Note, this
            // negative value is used as a shortcut in the PQ and
            // also to signify a left point.
            heights.add(List.of(left, -height));
            // End point has normal height value
            heights.add(List.of(right, height)); 
        }

        // Sort all the places the heights can change by
        // position. If two places are the same then:
        
        //  If height A negative (left point), height B positive (right point), position A (left) comes first
        //  If height A negative (left point), height B negative (left point), greatest height comes first
        //  If height A positive (right point), height B negative (right point), position B (right) comes first
        //  If height A positive (right point), height B positive (right point), height with lowest height comes first
        Collections.sort(heights, (a, b) -> {
                int positionA = a.get(0);
                int heightA = a.get(1);
            
                int positionB = b.get(0);
                int heightB = b.get(1);
            
                if(positionA != positionB) {
                    return positionA - positionB;
                }
                return heightA - heightB;
        });

        // Use a maxHeap to store possible heights in greatest order
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // Visit all points in order
        for(List<Integer> height: heights) {
            
            int position = height.get(0);
            int buildingHeight = height.get(1);
            
            // This is a start point, we can put it in
            // the priority queue.
            if(buildingHeight < 0) {
                pq.offer(-buildingHeight);
            // Otherwise this is an end point, we now
            // need to take it off the queue as we are
            // no longer in the remit of this building
            } else {
                pq.remove(buildingHeight);
            }
            int cur = pq.peek(); 

            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if(prev != cur) {
                result.add(List.of(position, cur));
                prev = cur;
            }
        }
        return result;
    }
}